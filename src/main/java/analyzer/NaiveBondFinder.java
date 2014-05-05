package analyzer;

import bonds.Bond;
import bonds.Structurer_Oxygen_bond;
import bonds.Structurer_Structurer_bond;
import lattice.Lattice;
import lattice.SquareLattice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import particles.Oxygen;
import particles.Particle;
import particles.Structurer;
import utils.IDGenerator;
import utils.Identifiable;
import utils.Parameters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * User: alpi
 * Date: 02.12.13
 * NaiveBondFinder provide interface for efficient bond finding.
 * It uses Schegel Algorithm for all-neighbour-within-distance finding based on lattice.
 */
public class NaiveBondFinder implements BondFinder, Identifiable {

    private static final Logger log = LoggerFactory.getLogger(NaiveBondFinder.class.getName());

    private static final IDGenerator idGenerator = new IDGenerator();
    private final int id = idGenerator.nextID();

    /**
     * Lattice is used for Schlegel all-neighbour-within-distance finding algorithm
     * Lattice period must not be less than maxBondLength. If it is too large, the algorithm degrade in speed.
     * The bond finder has exactly one lattice. To create finder
     */
    private Lattice lattice;

    @Override
    public int getID() {
        return id;
    }

    /**
     * NaiveBondFinder provide interface for efficient bond finding.
     * It uses Schegel Algorithm for all-neighbour-within-distance finding based on lattice.
     * Lattice period must not be less than maxBondLength. If it is too large, the algorithm degrade in speed.
     * The bond finder has exactly one lattice. To create finder
     *
     * @param maxBondLength maximum expected bond distance
     */
    public NaiveBondFinder(double maxBondLength) {
        int latticeDx = (int) Math.ceil(Parameters.get().getCUBE_DX() / maxBondLength);
        int latticeDy = (int) Math.ceil(Parameters.get().getCUBE_DY() / maxBondLength);
        int latticeDz = (int) Math.ceil(Parameters.get().getCUBE_DZ() / maxBondLength);
        this.lattice = new SquareLattice(latticeDx, latticeDy, latticeDz, maxBondLength);
    }

    /**
     * Finds all bonds that are possible according to bond length (assume no valency)
     *
     * @param structurers collection of structurer particles
     * @return collection of possible bonds
     */
    @Override
    public Collection<Structurer_Structurer_bond> find_S_S_bonds(Collection<Structurer> structurers) {
        TreeSet<Structurer_Structurer_bond> bonds = new TreeSet<>(Bond.idParticleComparator);

        ArrayList<Particle> particlesForLattice = new ArrayList<>(structurers.size());
        particlesForLattice.addAll(structurers);

        lattice.addParticles(particlesForLattice);

        for (Structurer s1 : structurers) {
            for (Particle particle : lattice.getNeighbours(s1)) {
                Structurer s2 = (Structurer) particle;
                if (Structurer_Structurer_bond.isBonded(s2, s1)) {
                    bonds.add(new Structurer_Structurer_bond(s2, s1));
                }
            }
        }

        return bonds;
    }

    /**
     * Finds all bonds that are possible according to bond length (assume no valency)
     *
     * @param structurers collection of structurer particles
     * @param oxygens     collection of oxygen particles
     * @return collection of possible bonds
     */
    @Override
    public Collection<Structurer_Oxygen_bond> find_S_O_bonds(Collection<Structurer> structurers, Collection<Oxygen> oxygens) {
        HashSet<Structurer_Oxygen_bond> bonds = new HashSet<>();

        ArrayList<Particle> particlesForLattice = new ArrayList<>();
        particlesForLattice.addAll(structurers);

        lattice.addParticles(particlesForLattice);

        for (Oxygen oxygen : oxygens) {
            for (Particle particle : lattice.getNeighbours(oxygen)) {
                Structurer structurer = (Structurer) particle;
                if (Structurer_Oxygen_bond.isBonded(structurer, oxygen)) {
                    bonds.add(new Structurer_Oxygen_bond(structurer, oxygen));
                }
            }
        }

        return bonds;
    }
}

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
 */
public class NaiveBondFinder implements BondFinder, Identifiable {

    private static final Logger log = LoggerFactory.getLogger(NaiveBondFinder.class.getName());

    private static final IDGenerator idGenerator = new IDGenerator();
    private final int id = idGenerator.nextID();
    private Lattice lattice;

    @Override
    public int getID() {
        return id;
    }

    public NaiveBondFinder(double maxBondDistance) {
        int latticeDx = (int) Math.ceil(Parameters.get().getCUBE_DX() / maxBondDistance);
        int latticeDy = (int) Math.ceil(Parameters.get().getCUBE_DY() / maxBondDistance);
        int latticeDz = (int) Math.ceil(Parameters.get().getCUBE_DZ() / maxBondDistance);
        this.lattice = new SquareLattice(latticeDx, latticeDy, latticeDz, maxBondDistance);
    }

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

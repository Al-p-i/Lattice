package analyzer;

import bonds.Bond;
import bonds.Modifier_Oxygen_bond;
import bonds.Structurer_Oxygen_bond;
import bonds.Structurer_Structurer_bond;
import lattice.Lattice;
import lattice.SquareLattice;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import particles.Modifier;
import particles.Oxygen;
import particles.Particle;
import particles.Structurer;
import utils.IDGenerator;
import utils.Identifiable;
import utils.Parameters;

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

    @Override
    public int getID() {
        return id;
    }


    @Override
    public Collection<Modifier_Oxygen_bond> find_M_O_bonds(@NotNull Collection<Modifier> modifiers, @NotNull Collection<Oxygen> oxygens) {
        HashSet<Modifier_Oxygen_bond> bonds = new HashSet<>();

        int latticeDx = (int) Math.ceil(Parameters.CUBE_DX / Modifier_Oxygen_bond.MAX_BOND_DISTANCE);
        int latticeDy = (int) Math.ceil(Parameters.CUBE_DY / Modifier_Oxygen_bond.MAX_BOND_DISTANCE);
        int latticeDz = (int) Math.ceil(Parameters.CUBE_DZ / Modifier_Oxygen_bond.MAX_BOND_DISTANCE);
        Lattice lattice = new SquareLattice(latticeDx, latticeDy, latticeDz, Modifier_Oxygen_bond.MAX_BOND_DISTANCE);

        Collection<Particle> particlesForLattice = new HashSet<>();

        particlesForLattice.addAll(modifiers);

        lattice.addParticles(particlesForLattice);

        for (Oxygen oxygen : oxygens) {
            for (Particle particle : lattice.getNeighbours(oxygen)) {
                Modifier modifier = (Modifier) particle;
                if (Modifier_Oxygen_bond.isBonded(modifier, oxygen)) {
                    bonds.add(new Modifier_Oxygen_bond(modifier, oxygen));
                }
            }
        }

        return bonds;
    }

    @Override
    public Collection<Structurer_Structurer_bond> find_S_S_bonds(@NotNull Collection<Structurer> structurers) {
        TreeSet<Structurer_Structurer_bond> bonds = new TreeSet<>(Bond.idParticleComparator);

        int latticeDx = (int) Math.ceil(Parameters.CUBE_DX / Modifier_Oxygen_bond.MAX_BOND_DISTANCE);
        int latticeDy = (int) Math.ceil(Parameters.CUBE_DY / Modifier_Oxygen_bond.MAX_BOND_DISTANCE);
        int latticeDz = (int) Math.ceil(Parameters.CUBE_DZ / Modifier_Oxygen_bond.MAX_BOND_DISTANCE);
        Lattice lattice = new SquareLattice(latticeDx, latticeDy, latticeDz, Modifier_Oxygen_bond.MAX_BOND_DISTANCE);

        Collection<Particle> particlesForLattice = new HashSet<>();

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
    public Collection<Structurer_Oxygen_bond> find_S_O_bonds(@NotNull Collection<Structurer> structurers, @NotNull Collection<Oxygen> oxygens) {
        HashSet<Structurer_Oxygen_bond> bonds = new HashSet<>();

        int latticeDx = (int) Math.ceil(Parameters.CUBE_DX / Modifier_Oxygen_bond.MAX_BOND_DISTANCE);
        int latticeDy = (int) Math.ceil(Parameters.CUBE_DY / Modifier_Oxygen_bond.MAX_BOND_DISTANCE);
        int latticeDz = (int) Math.ceil(Parameters.CUBE_DZ / Modifier_Oxygen_bond.MAX_BOND_DISTANCE);
        Lattice lattice = new SquareLattice(latticeDx, latticeDy, latticeDz, Modifier_Oxygen_bond.MAX_BOND_DISTANCE);

        Collection<Particle> particlesForLattice = new HashSet<>();

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

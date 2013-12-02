import analyzer.NaiveBondFinder;
import bonds.Structurer_Structurer_bond;
import particles.Structurer;
import utils.Parameters;
import utils.Utils;

import java.util.Collection;
import java.util.HashSet;

/**
 * User: alpi
 * Date: 02.12.13
 */
public class Main {
    public static void main(String[] args) {
        Collection<Structurer> structurers = new HashSet<>();
        for (int i = 0; i < 2; i++) {
            structurers.add(new Structurer(
                    Utils.getRandom().nextDouble() * Parameters.CUBE_DX * 1,
                    Utils.getRandom().nextDouble() * Parameters.CUBE_DY * 1,
                    Utils.getRandom().nextDouble() * Parameters.CUBE_DZ * 1));
        }

//        Collection<Oxygen> oxygens = new HashSet<>();
//        for (int i = 0; i < 10000; i++) {
//            oxygens.add(new Oxygen(
//                    Utils.getRandom().nextDouble() * Parameters.CUBE_DX * 1,
//                    Utils.getRandom().nextDouble() * Parameters.CUBE_DY * 1,
//                    Utils.getRandom().nextDouble() * Parameters.CUBE_DZ * 1));
//        }

        NaiveBondFinder naiveBondFinder = new NaiveBondFinder();

        Collection<Structurer_Structurer_bond> bonds = naiveBondFinder.find_S_S_bonds(structurers);

        System.out.println(bonds);
        System.out.println("bonds number = " + bonds.size());
//        int dxGrid = 100;
//        int dyGrid = 100;
//        int dzGrid = 100;
//        double boxSize = 1;
//
//        Lattice lattice = new SquareLattice(dxGrid, dyGrid, dzGrid, boxSize);
//        double dx = dxGrid * boxSize;
//        double dy = dyGrid * boxSize;
//        double dz = dzGrid * boxSize;
//
//        Collection<Particle> particles = new HashSet<>();
//
//        int N_OF_PARTICLES = 1_000;
//        for (int i = 0; i < N_OF_PARTICLES; i++) {
//            particles.add(new Modifier(
//                    Utils.getRandom().nextDouble() * dx,
//                    Utils.getRandom().nextDouble() * dy,
//                    Utils.getRandom().nextDouble() * dz));
//        }
//        lattice.addParticles(particles);
//
//        for (Particle particle : particles) {
//            System.out.println("----- " + particle + " neighbours -----");
//            System.out.println(lattice.getNeighbours(particle));
//        }
//        System.out.println("nOfActiveBoxes " + ((SquareLattice) lattice).getNOfActiveBoxes());
    }
}

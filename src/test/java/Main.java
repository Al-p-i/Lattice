import analyzer.NaiveBondFinder;
import bonds.Bond;
import bonds.Structurer_Structurer_bond;
import graph.PolimerizationGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) {
        //===== создаем частицы ==========
        Collection<Structurer> structurers = new HashSet<>();
        for (int i = 0; i < 1_000_000; i++) {
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

        //===== ищем связи ==========
        NaiveBondFinder naiveBondFinder = new NaiveBondFinder();

        log.info("bond finding started");
        Collection<Structurer_Structurer_bond> bonds = naiveBondFinder.find_S_S_bonds(structurers);
        log.info(bonds.size() + " bonds found");

        log.info("create graph");
        PolimerizationGraph polimerizationGraph = new PolimerizationGraph();
        for (Bond bond : bonds) {
            polimerizationGraph.addBond(bond);
        }
        log.info("graph created");


//        for(Particle particle: polimerizationGraph.graph.vertexSet())
//            System.out.println(polimerizationGraph.graph.degreeOf(particle));
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

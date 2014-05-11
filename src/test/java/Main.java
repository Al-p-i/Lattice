import analyzer.NaiveBondFinder;
import bonds.Bond;
import bonds.Structurer_Oxygen_bond;
import bonds.Structurer_Structurer_bond;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import particles.Oxygen;
import particles.ParticleType;
import particles.Structurer;

import java.util.ArrayList;
import java.util.Collection;

/**
 * User: alpi
 * Date: 02.12.13
 */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) {
//        closeStructurers();
        C2O4();

        /*
        //===== создаем частицы ==========
        Collection<Structurer> structurers = new HashSet<>();
        ParticleType particleType = new ParticleType("TestStructurer", (byte) 4, 0., 100);
        for (int i = 0; i < 1_000; i++) {
            structurers.add(new Structurer(
                    particleType,
                    Utils.getRandom().nextDouble() * Parameters.get().getCUBE_DX() * 1,
                    Utils.getRandom().nextDouble() * Parameters.get().getCUBE_DY() * 1,
                    Utils.getRandom().nextDouble() * Parameters.get().getCUBE_DZ() * 1));
        }

//        Collection<Oxygen> oxygens = new HashSet<>();
//        for (int i = 0; i < 10000; i++) {
//            oxygens.add(new Oxygen(
//                    Utils.getRandom().nextDouble() * Parameters.CUBE_DX * 1,
//                    Utils.getRandom().nextDouble() * Parameters.CUBE_DY * 1,
//                    Utils.getRandom().nextDouble() * Parameters.CUBE_DZ * 1));
//        }

        //===== ищем связи ==========
        NaiveBondFinder naiveBondFinder = new NaiveBondFinder(100);

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
*/
    }

    static void closeStructurers() {
        Collection<Structurer> structurers = new ArrayList<>();
        ParticleType particleType = new ParticleType("Structurer", (byte) 4, 0, 5);
        structurers.add(new Structurer(particleType, 50, 50, 50));
        structurers.add(new Structurer(particleType, 51, 50, 50));
        structurers.add(new Structurer(particleType, 52, 50, 50));
        structurers.add(new Structurer(particleType, 53, 50, 50));
        structurers.add(new Structurer(particleType, 54, 50, 50));
        NaiveBondFinder naiveBondFinder = new NaiveBondFinder(5);
        Collection<Structurer_Structurer_bond> S_S_bonds = naiveBondFinder.find_S_S_bonds(structurers);
        for (Bond bond : S_S_bonds) {
            System.out.println(bond);
        }
        assert S_S_bonds.size() == 10;
        Collection<Structurer_Oxygen_bond> S_O_bonds = naiveBondFinder.find_S_O_bonds(structurers, new ArrayList<Oxygen>());
        assert S_O_bonds.size() == 0;
    }

    static void C2O4() {
        Collection<Structurer> structurers = new ArrayList<>();
        Collection<Oxygen> oxygens = new ArrayList<>();
        ParticleType strType = new ParticleType("Structurer", (byte) 4, 0, 5);
        ParticleType oxType = new ParticleType("Oxygen", (byte) 4, 0, 4);
        structurers.add(new Structurer(strType, 50, 51, 50));
        structurers.add(new Structurer(strType, 50, 49, 50));
        oxygens.add(new Oxygen(oxType, 49, 50, 50));
        oxygens.add(new Oxygen(oxType, 48, 50, 50));
        oxygens.add(new Oxygen(oxType, 51, 50, 50));
        oxygens.add(new Oxygen(oxType, 52, 50, 50));
        NaiveBondFinder naiveBondFinder = new NaiveBondFinder(5);
        Collection<Structurer_Oxygen_bond> bonds = naiveBondFinder.find_S_O_bonds(structurers, oxygens);
        for (Bond bond : bonds) {
            System.out.println(bond);
        }
    }
}

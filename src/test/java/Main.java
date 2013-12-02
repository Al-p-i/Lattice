
import lattice.Lattice;
import lattice.SquareLattice;
import particles.ConcreteParticle;
import particles.Particle;
import utils.Utils;

import java.util.Collection;
import java.util.HashSet;

/**
 * User: alexeyk
 * Date: 02.12.13
 */
public class Main {
    public static void main(String[] args) {
        int dxGrid = 100;
        int dyGrid = 100;
        int dzGrid = 100;
        double boxSize = 1;

        Lattice lattice = new SquareLattice(dxGrid, dyGrid, dzGrid, boxSize);
        double dx = dxGrid * boxSize;
        double dy = dyGrid * boxSize;
        double dz = dzGrid * boxSize;

        Collection<Particle> particles = new HashSet<>();

        int N_OF_PARTICLES = 1_000;
        for (int i = 0; i < N_OF_PARTICLES; i++) {
            particles.add(new ConcreteParticle(
                    Utils.getRandom().nextDouble() * dx,
                    Utils.getRandom().nextDouble() * dy,
                    Utils.getRandom().nextDouble() * dz));
        }
        lattice.addParticles(particles);

        for (Particle particle : particles) {
            System.out.println("----- " + particle + " neighbours -----");
            System.out.println(lattice.getNeighbours(particle));
        }
        System.out.println("nOfActiveBoxes " + ((SquareLattice) lattice).getNOfActiveBoxes());
    }
}

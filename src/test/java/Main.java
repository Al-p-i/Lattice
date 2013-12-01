
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
        Lattice lattice = new SquareLattice(100, 100, 100, 1);

        Collection<Particle> particles = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            particles.add(new ConcreteParticle(
                    Utils.getRandom().nextDouble(),
                    Utils.getRandom().nextDouble(),
                    Utils.getRandom().nextDouble()));
        }
        lattice.addParticles(particles);

        for (Particle particle : particles) {
            System.out.println("----- " + particle + " neighbours -----");
            System.out.println(lattice.getNeighbours(particle));
        }
    }
}

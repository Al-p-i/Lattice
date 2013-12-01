package lattice;

import cell.Box;
import particles.Particle;

import java.util.Collection;

/**
 * User: alexeyk
 * Date: 24.11.13
 */
public interface Lattice {
    /**
     * box containing particle
     */
    Box getBox(Particle particle);

    Box getBox(int xGridIndex, int yGridIndex, int zGridIndex);

    /**
     * neighbours within 1-box neighbourhood (27 neighbouring boxes)
     */
    Collection<Particle> getNeighbours(Particle particle);

    void addParticles(Collection<Particle> particles);

    int getDX();

    int getDY();

    int getDZ();
}

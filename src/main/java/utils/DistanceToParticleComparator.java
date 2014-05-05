package utils;

import particles.Particle;

import java.util.Comparator;

/**
 * User: alpi
 * Date: 05.05.14
 * Compares two particles by distance to given particle
 */
public class DistanceToParticleComparator implements Comparator<Particle> {
    /**
     * Compares two particles by distance to given particle
     *
     * @param particle given particle
     */
    public DistanceToParticleComparator(Particle particle) {
        this.particle = particle;
    }

    private Particle particle;

    /**
     * Compares two particles by distance to given particle
     */
    @Override
    public int compare(Particle p1, Particle p2) {
        double dp1 = Geometry.distance(p1, particle);
        double dp2 = Geometry.distance(p2, particle);
        if (dp1 > dp2) return +1;
        if (dp1 < dp2) return -1;
        return 0;
    }
}

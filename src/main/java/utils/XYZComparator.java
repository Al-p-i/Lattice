package utils;

import particles.Particle;

import java.util.Comparator;

/**
 * Compares particles by coordinates in order X, Y, Z
 *
 * @author alpi
 * @since 11.05.14
 */
public class XYZComparator implements Comparator<Particle> {
    /**
     * Compares particles by coordinates in order X, Y, Z
     */
    @Override
    public int compare(Particle p1, Particle p2) {
        if (p1.getX() > p2.getX()) return +1;
        if (p1.getX() < p2.getX()) return -1;
        if (p1.getY() > p2.getY()) return +1;
        if (p1.getY() < p2.getY()) return -1;
        if (p1.getZ() > p2.getZ()) return +1;
        if (p1.getZ() < p2.getZ()) return -1;
        return 0;
    }
}

package geometry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import particles.Particle;

/**
 * User: alexeyk
 * Date: 02.12.13
 */
public class Geometry {

    private static final Logger log = LoggerFactory.getLogger(Geometry.class.getName());

    private Geometry() {
    }

    public static double distance(Particle p1, Particle p2) {
        return Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }
}

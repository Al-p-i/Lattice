package bonds;

import particles.Particle;
import utils.Pair;

/**
 * User: alexeyk
 * Date: 02.12.13
 */
public interface Bond {
    Pair<? extends Particle, ? extends Particle> getPair();

    double getLength();
}

package particles;

import utils.Identifiable;

/**
 * User: alpi
 * Date: 26.11.13
 */
public interface Particle extends Identifiable {
    String getName();

    byte getValency();

    double getX();

    double getY();

    double getZ();
}

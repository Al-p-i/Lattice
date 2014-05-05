package particles;

import utils.Identifiable;

/**
 * User: alpi
 * Date: 26.11.13
 */
public interface Particle extends Identifiable {
    String getName();

    double getMinBondDistance();

    double getMaxBondDistance();

    byte getValency();

    double getX();

    double getY();

    double getZ();
}

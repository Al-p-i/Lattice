package particles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.IDGenerator;
import utils.Identifiable;

/**
 * User: alpi
 * Date: 02.12.13
 */
public abstract class ConcreteParticle implements Particle, Identifiable {

    private static final Logger log = LoggerFactory.getLogger(ConcreteParticle.class.getName());

    private static final IDGenerator idGenerator = new IDGenerator();
    private final int id = idGenerator.nextID();

    private double x;
    private double y;
    private double z;

    public ConcreteParticle(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConcreteParticle that = (ConcreteParticle) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public final int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "id=" + getID();// + "[" + x + ", " + y + ", " + z + "]";
    }
}

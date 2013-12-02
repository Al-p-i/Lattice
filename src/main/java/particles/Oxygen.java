package particles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: alpi
 * Date: 02.12.13
 */
public class Oxygen extends ConcreteParticle {

    private static final Logger log = LoggerFactory.getLogger(Oxygen.class.getName());

    public Oxygen(double x, double y, double z) {
        super(x, y, z);
    }

    @Override
    public String toString() {
        return "(oxygen: " + super.toString() + ")";// + "[" + x + ", " + y + ", " + z + "]";
    }
}

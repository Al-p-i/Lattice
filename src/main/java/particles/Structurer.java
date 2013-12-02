package particles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: alexeyk
 * Date: 02.12.13
 */
public class Structurer extends ConcreteParticle {

    private static final Logger log = LoggerFactory.getLogger(Structurer.class.getName());

    public Structurer(double x, double y, double z) {
        super(x, y, z);
        log.info(toString());
    }

    @Override
    public String toString() {
        return "structurer: " + super.toString();// + "[" + x + ", " + y + ", " + z + "]";
    }
}

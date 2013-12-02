package particles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: alexeyk
 * Date: 02.12.13
 */
public class Modifier extends ConcreteParticle {

    private static final Logger log = LoggerFactory.getLogger(Modifier.class.getName());


    public Modifier(double x, double y, double z) {
        super(x, y, z);
        log.info(toString());
    }

    @Override
    public String toString() {
        return "modifier: " + super.toString();// + "[" + x + ", " + y + ", " + z + "]";
    }
}

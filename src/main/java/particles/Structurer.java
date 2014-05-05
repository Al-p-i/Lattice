package particles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: alpi
 * Date: 02.12.13
 */
public class Structurer extends ConcreteParticle {

    private static final Logger log = LoggerFactory.getLogger(Structurer.class.getName());


    public Structurer(ParticleType particleType, double x, double y, double z) {
        super(particleType, x, y, z);
        log.info(toString());
    }

    @Override
    public String toString() {
        return "(structurer: " + super.toString() + ")";// + "[" + x + ", " + y + ", " + z + "]";
    }
}

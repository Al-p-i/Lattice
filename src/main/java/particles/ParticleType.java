package particles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.IDGenerator;
import utils.Identifiable;

/**
 * User: alexeyk
 * Date: 05.05.14
 */
public class ParticleType implements Identifiable {

    private static final Logger log = LoggerFactory.getLogger(ParticleType.class.getName());

    private static final IDGenerator idGenerator = new IDGenerator();
    private final int id = idGenerator.nextID();

    private final String name;
    private final byte valency;
    private final double minBondDistance;
    private final double maxBoundDistance;

    public ParticleType(String name, byte valency, double minBondDistance, double maxBoundDistance) {
        this.name = name;
        this.valency = valency;
        this.minBondDistance = minBondDistance;
        this.maxBoundDistance = maxBoundDistance;
    }

    @Override
    public int getID() {
        return id;
    }

    public byte getValency() {
        return valency;
    }

    public String getName() {
        return name;
    }

    public double getMinBondDistance() {
        return minBondDistance;
    }

    public double getMaxBoundDistance() {
        return maxBoundDistance;
    }
}

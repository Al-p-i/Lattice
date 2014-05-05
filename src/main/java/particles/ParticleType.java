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

    public ParticleType(String name, byte valency) {
        this.name = name;
        this.valency = valency;
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
}

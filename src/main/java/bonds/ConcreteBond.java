package bonds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Geometry;
import utils.IDGenerator;
import utils.Identifiable;

/**
 * User: alexeyk
 * Date: 02.12.13
 */
public abstract class ConcreteBond implements Bond, Identifiable {

    private static final Logger log = LoggerFactory.getLogger(ConcreteBond.class.getName());

    private static final IDGenerator idGenerator = new IDGenerator();
    private final int id = idGenerator.nextID();


    @Override
    public int getID() {
        return id;
    }


    @Override
    public double getLength() {
        return Geometry.distance(getPair().getObj1(), getPair().getObj2());
    }
}

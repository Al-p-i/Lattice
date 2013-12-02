package bonds;

import geometry.Geometry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import particles.Structurer;
import utils.Pair;

/**
 * User: alexeyk
 * Date: 02.12.13
 */
public class Structurer_Structurer_bond extends ConcreteBond {

    private static final Logger log = LoggerFactory.getLogger(Structurer_Structurer_bond.class.getName());

    private Structurer first;
    private Structurer second;

    public Structurer_Structurer_bond(Structurer first, Structurer second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Pair<Structurer, Structurer> getPair() {
        return new Pair<>(first, second);
    }

    public static final double MAX_BOND_DISTANCE = 10;
    public static final double MIN_BOND_DISTANCE = 0;

    public static boolean isBonded(Structurer first, Structurer second) {
        return Geometry.distance(first, second) < MAX_BOND_DISTANCE &&
                Geometry.distance(first, second) > MIN_BOND_DISTANCE;
    }
}

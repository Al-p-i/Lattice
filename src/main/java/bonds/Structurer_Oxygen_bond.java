package bonds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import particles.Oxygen;
import particles.Structurer;
import utils.Geometry;
import utils.Pair;

/**
 * User: alexeyk
 * Date: 02.12.13
 */
public class Structurer_Oxygen_bond extends ConcreteBond {
    private static final Logger log = LoggerFactory.getLogger(Structurer_Oxygen_bond.class.getName());

    private Structurer structurer;
    private Oxygen oxygen;

    public Structurer_Oxygen_bond(Structurer structurer, Oxygen oxygen) {
        this.structurer = structurer;
        this.oxygen = oxygen;
    }

    public Structurer_Oxygen_bond(Oxygen oxygen, Structurer structurer) {
        this(structurer, oxygen);
    }

    @Override
    public Pair<Structurer, Oxygen> getPair() {
        return new Pair<>(structurer, oxygen);
    }

    public static final double MAX_BOND_DISTANCE = 10;
    public static final double MIN_BOND_DISTANCE = 0;

    public static boolean isBonded(Structurer structurer, Oxygen oxygen) {
        return Geometry.distance(structurer, oxygen) < MAX_BOND_DISTANCE &&
                Geometry.distance(structurer, oxygen) > MIN_BOND_DISTANCE;
    }
}

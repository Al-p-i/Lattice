package bonds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import particles.Modifier;
import particles.Oxygen;
import utils.Geometry;
import utils.Pair;

/**
 * User: alexeyk
 * Date: 02.12.13
 */
public class Modifier_Oxygen_bond extends ConcreteBond {

    private static final Logger log = LoggerFactory.getLogger(Modifier_Oxygen_bond.class.getName());

    private Modifier modifier;
    private Oxygen oxygen;

    public Modifier_Oxygen_bond(Modifier modifier, Oxygen oxygen) {
        this.modifier = modifier;
        this.oxygen = oxygen;
    }

    @Override
    public Pair<Modifier, Oxygen> getPair() {
        return new Pair<>(modifier, oxygen);
    }

    public static final double MAX_BOND_DISTANCE = 10;
    public static final double MIN_BOND_DISTANCE = 0;

    public static boolean isBonded(Modifier modifier, Oxygen oxygen) {
        return Geometry.distance(modifier, oxygen) < MAX_BOND_DISTANCE &&
                Geometry.distance(modifier, oxygen) > MIN_BOND_DISTANCE;
    }
}

package bonds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import particles.Structurer;
import utils.Geometry;
import utils.Pair;

/**
 * User: alpi
 * Date: 02.12.13
 * Bond between two Structurer particles
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

    public static boolean isBonded(Structurer first, Structurer second) {
        double distance = Geometry.distance(first, second);
        return distance < first.getMaxBondDistance() &&
                distance < second.getMaxBondDistance() &&
                distance > first.getMinBondDistance() &&
                distance > second.getMinBondDistance();
    }
}

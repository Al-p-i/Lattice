package bonds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import particles.Particle;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Structurer_Structurer_bond that = (Structurer_Structurer_bond) o;

        if (!first.equals(that.first)) return false;
        if (!second.equals(that.second)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + second.hashCode();
        return result;
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

    /**
     * The less structurer by XYZComparator comes first
     * return new Bond with less structurer as first
     */
    @Override
    public Structurer_Structurer_bond canonical() {
        if (Particle.xyzComparator.compare(first, second) < 0) return new Structurer_Structurer_bond(first, second);
        return new Structurer_Structurer_bond(second, first);
    }
}

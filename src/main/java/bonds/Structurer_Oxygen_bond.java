package bonds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import particles.Oxygen;
import particles.Structurer;
import utils.Geometry;
import utils.Pair;

/**
 * User: alpi
 * Date: 02.12.13
 * Bond between Oxigen and Structurer particles
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

    public Structurer getStructurer() {
        return structurer;
    }

    public Oxygen getOxygen() {
        return oxygen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Structurer_Oxygen_bond that = (Structurer_Oxygen_bond) o;

        if (!oxygen.equals(that.oxygen)) return false;
        if (!structurer.equals(that.structurer)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = structurer.hashCode();
        result = 31 * result + oxygen.hashCode();
        return result;
    }

    @Override
    public Pair<Structurer, Oxygen> getPair() {
        return new Pair<>(structurer, oxygen);
    }

    public static boolean isBonded(Structurer first, Oxygen second) {
        double distance = Geometry.distance(first, second);
        return distance < first.getMaxBondDistance() &&
                distance < second.getMaxBondDistance() &&
                distance > first.getMinBondDistance() &&
                distance > second.getMinBondDistance();
    }

    /**
     * has no affect
     *
     * @return this
     */
    @Override
    public Structurer_Oxygen_bond canonical() {
        return this;
    }
}

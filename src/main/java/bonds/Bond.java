package bonds;

import particles.Particle;
import utils.Identifiable;
import utils.Pair;

import java.util.Comparator;

/**
 * User: alpi
 * Date: 02.12.13
 * Chemical bond
 */
public interface Bond {
    Pair<? extends Particle, ? extends Particle> getPair();

    double getLength();

    public static Comparator<Bond> idParticleComparator = new Comparator<Bond>() {
        @Override
        public int compare(Bond b1, Bond b2) {
            if (b1.getPair().equals(b2.getPair()))
                return 0;
            else if (Identifiable.idComparator.compare(b1.getPair().getObj1(), b2.getPair().getObj1()) != 0)
                return Identifiable.idComparator.compare(b1.getPair().getObj1(), b2.getPair().getObj1());
            else return Identifiable.idComparator.compare(b1.getPair().getObj2(), b2.getPair().getObj2());
        }
    };
}

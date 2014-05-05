package analyzer;

import bonds.Structurer_Oxygen_bond;
import bonds.Structurer_Structurer_bond;
import particles.Oxygen;
import particles.Structurer;

import java.util.Collection;

/**
 * User: alpi
 * Date: 02.12.13
 * NaiveBondFinder provide interface for bond finding.
 */
public interface BondFinder {

    Collection<Structurer_Structurer_bond> find_S_S_bonds(
            Collection<Structurer> structurers);

    Collection<Structurer_Oxygen_bond> find_S_O_bonds(
            Collection<Structurer> structurers,
            Collection<Oxygen> oxygens);
}

package analyzer;

import bonds.Modifier_Oxygen_bond;
import bonds.Structurer_Oxygen_bond;
import bonds.Structurer_Structurer_bond;
import particles.Modifier;
import particles.Oxygen;
import particles.Structurer;

import java.util.Collection;

/**
 * User: alpi
 * Date: 02.12.13
 */
public interface BondFinder {
    public Collection<Modifier_Oxygen_bond> find_M_O_bonds(
            Collection<Modifier> modifiers,
            Collection<Oxygen> oxygens);

    Collection<Structurer_Structurer_bond> find_S_S_bonds(
            Collection<Structurer> structurers);

    Collection<Structurer_Oxygen_bond> find_S_O_bonds(
            Collection<Structurer> structurers,
            Collection<Oxygen> oxygens);
}

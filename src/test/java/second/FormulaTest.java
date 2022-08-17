package second;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class FormulaTest {

    @Test
    void creatFormulaTest() {
        Formula formula = new Formula("1 + 3 - 2 / 3");
        assertThat(formula).isNotNull();
    }

    @Test
    void formulaCalculate() {
        Formula formula = new Formula("6 + 3 - 2 * 2 + 1 / 3");
        int sum = formula.calculate();
        assertThat(sum).isEqualTo(5);
    }

    @Test
    void invalidateFormula() {
        assertThrows(IllegalArgumentException.class, () -> new Formula("6 1 3 - 2 * 2 + 1 / 3"));
    }

    @Test
    void invalidateFormulaChar() {
        assertThrows(IllegalArgumentException.class, () -> new Formula("a + 3 - b * 2 + 1 / 3"));
    }

}
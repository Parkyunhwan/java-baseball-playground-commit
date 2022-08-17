package third;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class FormulaTest {

    @ParameterizedTest
    @ValueSource(strings = "8 + 2 - 3 * 2 / 2")
    void createFormulaTestSuccess(String value) {
        Assertions.assertDoesNotThrow(() -> Formula.createFormula(value));
    }

    @ParameterizedTest
    @ValueSource(strings = "8 8 2 - 3 * 2 - 2")
    void createFormulaTestFail(String value) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Formula.createFormula(value), "해당 문자에 맞는 연산자가 존재하지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = "8 + 2")
    void formulaNextMethodSuccess(String value) {
        Formula formula = Formula.createFormula(value);
        assertEquals(formula.nextOperand(), 8);
        assertEquals(formula.nextOperand(), 2);
    }

    @ParameterizedTest
    @ValueSource(strings = "8 + 2")
    void formulaNextMethodFail(String value) {
        Formula formula = Formula.createFormula(value);
        assertEquals(formula.nextOperand(), 8);
        assertEquals(formula.nextOperand(), 2);
        assertThrows(IllegalStateException.class, () -> formula.nextOperand());
    }

    @ParameterizedTest
    @ValueSource(strings = "8 + 2 * 3")
    void formulaNextOperatorSuccess(String value) {
        Formula formula = Formula.createFormula(value);
        assertEquals(formula.nextOperator(), "+");
        assertEquals(formula.nextOperator(), "*");
    }

    @ParameterizedTest
    @ValueSource(strings = "8 + 2 - 3")
    void formulaNextOperatorFail(String value) {
        Formula formula = Formula.createFormula(value);
        assertEquals(formula.nextOperator(), "+");
        assertEquals(formula.nextOperator(), "-");
        assertThrows(IllegalStateException.class, () -> formula.nextOperator());
    }

    @ParameterizedTest
    @ValueSource(strings = "8 + 2 - 3")
    void formulaHasNextOperatorFail(String value) {
        Formula formula = Formula.createFormula(value);
        assertEquals(formula.nextOperator(), "+");
        assertEquals(formula.nextOperator(), "-");
        assertFalse(formula.hasNextOperator());
    }

    @ParameterizedTest
    @ValueSource(strings = "8 + 2 - 3")
    void formulaHasNextOperatorSuccess(String value) {
        Formula formula = Formula.createFormula(value);
        assertTrue(formula.hasNextOperator());
    }

    @ParameterizedTest
    @ValueSource(strings = "8 + 2 - 3")
    void formulaClearIdxBefore(String value) throws NoSuchFieldException, IllegalAccessException {
        Formula formula = Formula.createFormula(value);
        formula.nextOperator();
        formula.nextOperator();
        formula.nextOperand();
        Field operandsIdx = formula.getClass().getDeclaredField("operandsIdx");
        Field operatorsIdx = formula.getClass().getDeclaredField("operatorsIdx");
        operandsIdx.setAccessible(true);
        operatorsIdx.setAccessible(true);

        int operatorI = (int) operatorsIdx.get(formula);
        int operandI = (int) operandsIdx.get(formula);
        assertEquals(operandI, 1);
        assertEquals(operatorI, 2);
    }

    @ParameterizedTest
    @ValueSource(strings = "8 + 2 - 3")
    void formulaClearIdxZero(String value) throws NoSuchFieldException, IllegalAccessException {
        Formula formula = Formula.createFormula(value);
        formula.nextOperator();
        formula.nextOperator();
        formula.nextOperand();
        formula.clearIdx();
        Field operandsIdx = formula.getClass().getDeclaredField("operandsIdx");
        Field operatorsIdx = formula.getClass().getDeclaredField("operatorsIdx");
        operandsIdx.setAccessible(true);
        operatorsIdx.setAccessible(true);

        int operatorI = (int) operatorsIdx.get(formula);
        int operandI = (int) operandsIdx.get(formula);
        assertEquals(operandI, 0);
        assertEquals(operatorI, 0);
    }

}
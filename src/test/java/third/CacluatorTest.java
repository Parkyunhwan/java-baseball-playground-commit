package third;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CacluatorTest {
    @ParameterizedTest
    @CsvSource(value = "5 + 2 * 2 + 7 / 3,7", delimiter = ',')
    void calculateByFormulaSuccess(String value, int result) {
        Formula formula = Formula.createFormula(value);
        int sum = Calculator.calculateByFormula(formula);
        assertEquals(sum, result);
    }

    @ParameterizedTest
    @CsvSource(value = "5 + 2 * 2 + 7 / 3,7", delimiter = ',')
    void calculateByStringSuccess(String value, int result) {
        int sum = Calculator.calculateByString(value);
        assertEquals(sum, result);
    }

    @ParameterizedTest
    @CsvSource(value = "5 + 2 3 2 + 7 / 3,7", delimiter = ',')
    void calculateByStringFail(String value, int result) {
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculateByString(value));
    }
}
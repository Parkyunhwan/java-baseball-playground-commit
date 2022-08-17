package third;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class FormulaInputValidationTest {

    FormulaInputValidation formulaInputValidation;

    @BeforeEach
    void init() {
        formulaInputValidation = new FormulaInputValidation();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "13", "12412"})
    void isNotNumberTest_parameterNumber(String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = FormulaInputValidation.class.getDeclaredMethod("isNotNumber", String.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(formulaInputValidation, value);
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1#", "123~13", ""})
    void isNotNumberTest_parameterNotNumber(String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = FormulaInputValidation.class.getDeclaredMethod("isNotNumber", String.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(formulaInputValidation, value);
        assertTrue(result);
    }


    @ParameterizedTest
    @EnumSource(Operator.class)
    void isNotValidOperator_success(Operator operator) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = FormulaInputValidation.class.getDeclaredMethod("isNotValidOperator", String.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(formulaInputValidation, operator.getSymbol());
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"$", "#", "X"})
    void isNotValidOperator_fail(String symbol) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = FormulaInputValidation.class.getDeclaredMethod("isNotValidOperator", String.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(formulaInputValidation, symbol);
        assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "+:1", "34:2", "*:5"}, delimiter = ':')
    void validComponent_success(String str, Integer idx) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = FormulaInputValidation.class.getDeclaredMethod("validComponent", String.class, int.class);
        method.setAccessible(true);
        assertDoesNotThrow(() -> method.invoke(formulaInputValidation, str, idx));
    }

    @ParameterizedTest
    @CsvSource(value = {"+:0", "+:2", "34:3", "*:8"}, delimiter = ':')
    void validComponent_fail(String str, Integer idx) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = FormulaInputValidation.class.getDeclaredMethod("validComponent", String.class, int.class);
        method.setAccessible(true);
        InvocationTargetException invocationTargetException = null;
        try {
            method.invoke(formulaInputValidation, str, idx);
        } catch (InvocationTargetException exception) {
            invocationTargetException = exception;
        }
        assertNotNull(invocationTargetException);
        assertTrue(invocationTargetException.getTargetException() instanceof IllegalArgumentException);
    }
}
package second;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void validOperator(String value) {
        assertThat(Operator.isValidOperator(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"$", "1", "&", "t"})
    void notValidOperator(String value) {
        assertThat(Operator.isValidOperator(value)).isFalse();
    }


    @Test
    void selectOperatorPlus() {
        assertThat(Operator.selectOperator("+")).isEqualTo(Operator.PLUS);
    }

    @Test
    void selectOperatorMultiply() {
        assertThat(Operator.selectOperator("*")).isEqualTo(Operator.MULTIPLY);
    }

    @Test
    void selectOperatorMinus() {
        assertThat(Operator.selectOperator("-")).isEqualTo(Operator.MINUS);
    }

    @Test
    void selectOperatorDivide() {
        assertThat(Operator.selectOperator("/")).isEqualTo(Operator.DIVIDE);
    }

    @Test
    void calculateByOpeartorPlus() {
        Operator plus = Operator.PLUS;
        assertThat(plus.calculateByOpeartor(7, 17)).isEqualTo(24);
    }

    @Test
    void calculateByOpeartorMinus() {
        Operator plus = Operator.MINUS;
        assertThat(plus.calculateByOpeartor(7, 17)).isEqualTo(-10);
    }

    @Test
    void calculateByOpeartorMultiply() {
        Operator plus = Operator.MULTIPLY;
        assertThat(plus.calculateByOpeartor(7, 17)).isEqualTo(119);
    }

    @Test
    void calculateByOpeartorDivide() {
        Operator plus = Operator.DIVIDE;
        assertThat(plus.calculateByOpeartor(34, 17)).isEqualTo(2);
    }
}
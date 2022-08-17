package second;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 1. 문자열 계산식을 피연산자와 연산자로 나누는 책임 (완료)
 * 2. 피연산자와 연산자를 가지고 계산하는 책임 (완료)
 * 3. 연산자에 따라 계산로직을 선택하는 책임
 */
class StringCalculatorTest {


    @Test
    void executeTest() {
        StringCalculator stringCalculator = new StringCalculator("1 + 3 - 2 * 3");
        Assertions.assertThat(stringCalculator.execute()).isEqualTo(6);
        Assertions.assertThat(stringCalculator.execute()).isEqualTo(6);
    }




}
package baseball.second;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class BallNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void Ball은1부터9사이의숫자(int num) {
        assertThatCode(() -> new BallNumber(num))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 11, -1})
    void Ball은1부터9사이의숫자가아니라면IllegalArgument예외발생(int number) {
        assertThatThrownBy(() -> new BallNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9사이의 숫자만 가능합니다.");
    }
}

package baseball.second;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallLocationTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void Ball은1부터9사이의숫자(int num) {
        assertThatCode(() -> new BallLocation(num))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 11, -1})
    void Ball은1부터9사이의숫자가아니라면IllegalArgument예외발생(int number) {
        assertThatThrownBy(() -> new BallLocation(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("볼의위치는 1~3사이의만 가능합니다.");
    }
}

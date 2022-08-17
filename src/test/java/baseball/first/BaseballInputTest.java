package baseball.first;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BaseballInputTest {


    @ParameterizedTest
    @ValueSource(strings = {"123", "293", "521"})
    void inputTest(String strs) {
        inputHandling(strs);
        String input = BaseballInput.inputByConsole();
        assertThat(input).isEqualTo(strs);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "293", "521"})
    void validateSuccessTest(String str) {
        BaseballInput.validate(str);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12a", "29312", "bbb", "12"})
    void validateFailTest(String str) {
        assertThrows(IllegalStateException.class, () -> BaseballInput.validate(str));
    }

    public static void inputHandling(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
    }


}
package baseball.first;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    @Test
    void baseballTest() throws NoSuchFieldException, IllegalAccessException {
        inputHandling("123");
        BaseballGame.startBaseballGame();
    }

    public static void inputHandling(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
    }
}
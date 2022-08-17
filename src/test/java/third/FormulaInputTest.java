package third;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class FormulaInputTest {

    private FormulaInput formulaInput;

    @BeforeEach
    void init() {
        formulaInput = new FormulaInput();
    }

    @Test
    void createFormulaByConsoleTest() {
        inputHandling("1 + 2 - 3 * 4 / 5");
        formulaInput.createFormulaByConsole();
    }

    public static void inputHandling(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
    }
}
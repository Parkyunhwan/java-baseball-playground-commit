package third;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 콘솔에는 올바른 형태의 계산식이 입력되어야만 한다.
 *
 */
public class FormulaInput {

    public Formula createFormulaByConsole() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return Formula.createFormula(line);
    }
}

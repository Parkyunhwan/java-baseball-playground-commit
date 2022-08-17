package second;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final BinaryOperator<Integer> process;

    Operator(String symbol, BinaryOperator<Integer> process) {
        this.symbol = symbol;
        this.process = process;
    }

    public static boolean isValidOperator(String input) {
        return Arrays.stream(Operator.values())
                .anyMatch((operator -> operator.symbol.equals(input)));
    }

    public int calculateByOpeartor(int operand1, int operand2) {
        return this.process.apply(operand1, operand2);
    }

    public static Operator selectOperator(String operator) {
        return Arrays.stream(Operator.values())
                .filter((oper) -> oper.isSame(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 연산자 없음"));
    }

    private boolean isSame(String operator) {
        return this.symbol.equals(operator);
    }

}

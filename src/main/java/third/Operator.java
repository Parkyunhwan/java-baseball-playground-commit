package third;

import java.util.Arrays;
import java.util.function.BinaryOperator;


public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y),
    ;

    public String getSymbol() {
        return symbol;
    }

    Operator(String symbol, BinaryOperator<Integer> calculate) {
        this.symbol = symbol;
        this.calculate = calculate;
    }

    private final String symbol;
    private final BinaryOperator<Integer> calculate;

    public static Operator fromString(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(value -> value.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 문자에 맞는 연산자가 존재하지 않습니다."));
    }

    public int calculateByOperator(int operand1, int operand2) {
        return calculate.apply(operand1, operand2);
    }
}

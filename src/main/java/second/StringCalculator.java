package second;

public class StringCalculator {
    private final Formula formula;

    public StringCalculator(String value) {
        formula = new Formula(value);
    }

    public int execute() {
        return formula.calculate();
    }
}

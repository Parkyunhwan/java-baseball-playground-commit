package third;

public class Calculator {
    public static int calculateByFormula(Formula formula) {
        int result = formula.nextOperand();
        while (formula.hasNextOperator()) {
            String operatorSymbol = formula.nextOperator();
            Operator currOperator = Operator.fromString(operatorSymbol);
            result = currOperator.calculateByOperator(result, formula.nextOperand());
        }
        formula.clearIdx();
        return result;
    }

    public static int calculateByString(String strs) {
        Formula formula = Formula.createFormula(strs);
        int result = formula.nextOperand();
        while (formula.hasNextOperator()) {
            String operatorSymbol = formula.nextOperator();
            Operator currOperator = Operator.fromString(operatorSymbol);
            result = currOperator.calculateByOperator(result, formula.nextOperand());
        }
        return result;
    }
}

package second;

import java.util.*;

public class Formula {

    private final Operators operators = new Operators();
    private final Operands operands = new Operands();

    public Formula(String value) {
        convertStringToFormula(value);
    }

    private void convertStringToFormula(String value) {
        String[] values = value.split(" ");
        for (String str : values) {
            insertToFormulaComponent(str);
        }

        validateFormula();
    }

    private void validateFormula() {
        if (operators.size() + 1 == operands.size())
            return;

        throw new IllegalArgumentException("올바른 계산식 형태가 아닙니다.");
    }

    private void insertToFormulaComponent(String str) {
        if (Operator.isValidOperator(str)) {
            operators.addOperator(str);
            return;
        }

        if (isDigitString(str)) {
            operands.addOperand(Integer.parseInt(str));
            return;
        }

        throw new IllegalArgumentException("올바른 계산식값이 아닙니다.");
    }

    public int calculate() {
        int sum = operands.getNextOperand();
        while (operators.hasNext()) {
            String operator = operators.getNextOperator();
            Operator currOperator = Operator.selectOperator(operator);
            sum = currOperator.calculateByOpeartor(sum, operands.getNextOperand());
        }
        clearIdx();
        return sum;
    }

    private void clearIdx() {
        operators.clearIdx();
        operands.clearIdx();
    }

    private boolean isDigitString(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    private static class Operands {
        private final List<Integer> operands = new ArrayList<>();
        private int idx = 0;

        public void addOperand(Integer operator) {
            operands.add(operator);
        }

        public int getNextOperand() {
            return operands.get(idx++);
        }

        public void clearIdx() {
            idx = 0;
        }

        public int size() {
            return operands.size();
        }
    }

    private static class Operators {
        private final List<String> operators = new ArrayList<>();
        private int idx = 0;

        public void addOperator(String operator) {
            operators.add(operator);
        }

        public String getNextOperator() {
            return operators.get(idx++);
        }

        public void clearIdx() {
            idx = 0;
        }

        public boolean hasNext() {
            return operators.size() > idx;
        }

        public int size() {
            return operators.size();
        }
    }
}



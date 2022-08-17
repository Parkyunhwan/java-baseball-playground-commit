package third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Formula {
    private final List<Integer> operands = new ArrayList<>();
    private final List<String> operators = new ArrayList<>();
    private int operandsIdx = 0;
    private int operatorsIdx = 0;

    private Formula() {
    }

    public static Formula createFormula(String strs) {
        FormulaInputValidation.validation(strs);
        String[] form = strs.split(" ");
        Formula formula = new Formula();
        for (int i = 0; i < form.length; i++) {
            if ((i + 1) % 2 == 1) { // 홀수
                formula.operands.add(Integer.parseInt(form[i]));
            } else {
                formula.operators.add(form[i]);
            }
        }
        return formula;
    }

    int nextOperand() {
        if (operands.size() <= operandsIdx) {
            throw new IllegalStateException("계산식에 피연산자가 존재하지 않습니다.");
        }
        return operands.get(operandsIdx++);
    }
    String nextOperator() {
        if (operators.size() <= operatorsIdx) {
            throw new IllegalStateException("계산식에 연산자가 존재하지 않습니다.");
        }
        return operators.get(operatorsIdx++);
    }

    boolean hasNextOperator() {
        return operators.size() > operatorsIdx;
    }

    void clearIdx() {
        operatorsIdx = 0;
        operandsIdx = 0;
    }
}

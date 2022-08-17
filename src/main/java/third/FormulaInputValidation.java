package third;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 1. 문자열의 첫번째는 숫자여야만한다. (공백또는 숫자 이외의 값이 올 수 없음)
 * 2. 공백을 제외하였을 때 홀수값에는 숫자만 들어있는가 (올바른 피연산자)
 * 3. 짝수값에 유효한 연산자가 들어있는지 체크
 */
public class FormulaInputValidation {
    private static final String NUMBER_PATTERN = "^[0-9]+$";
    private static final Pattern numberPattern = Pattern.compile(NUMBER_PATTERN);

    public static void validation(String str) {
        List<String> strs = Arrays.asList(str.split(" "));
        validFirstCharNumber(strs);
        validOpeartorAndOperation(strs);
    }

    private static void validOpeartorAndOperation(List<String> strs) {
        for (int i = 0; i < strs.size(); i++) {
            validComponent(strs.get(i), i);
        }
    }

    private static void validComponent(String str, int i) {
        if ((i + 1) % 2 == 0) { // even
            validOperator(str);
        } else {
            validOddCharNumber(str);
        }
    }

    private static void validOperator(String str) {
        if (isNotValidOperator(str)) {
            throw new IllegalArgumentException("문자열의 짝수번째는 유효한 연산자값이여야만 합니다.");
        }
    }

    private static void validOddCharNumber(String str) {
        if (isNotNumber(str)) {
            throw new IllegalArgumentException("문자열의 홀수번째는 숫자여야만 합니다.");
        }
    }

    private static boolean isNotValidOperator(String str) {
        try {
            Operator.fromString(str);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return true;
        }
        return false;
    }

    private static void validFirstCharNumber(List<String> strs) {
        if (strs.isEmpty()) {
            throw new IllegalStateException("문자열이 계산식이 아닙니다.");
        }

        String s = strs.get(0);
        if (isNotNumber(s)) {
            throw new IllegalStateException("문자열이 계산식이 아닙니다.");
        }
    }

    private static boolean isNotNumber(String s) {
        return !numberPattern.matcher(s).find();
    }
}

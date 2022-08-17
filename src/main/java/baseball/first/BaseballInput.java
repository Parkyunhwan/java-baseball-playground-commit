package baseball.first;

import java.util.Scanner;

public class BaseballInput {

    public static String inputByConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해 주세요 : ");
        String s = scanner.nextLine();
        validate(s);
        return s;
    }

    public static String inputZeroOrOne() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        validateZeroOrOne(s);
        return s;
    }

    private static void validateZeroOrOne(String s) {
        if (s.length() != 1) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }

        if (!s.equals("1") && !s.equals("0")) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }
    }


    public static void validate(String line) {
        validateLength(line);
        validateNumber(line);
    }

    private static void validateNumber(String strs) {
        if (!strs.chars().allMatch(Character::isDigit)) {
            throw new IllegalStateException("숫자로만 이뤄진 문자열이 아닙니다.");
        }
    }

    private static void validateLength(String s) {
        if (s.length() != 3) {
            throw new IllegalStateException("길이는 3이어야만 합니다.");
        }
    }
}

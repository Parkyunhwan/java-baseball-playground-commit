package baseball.first;

public class BaseballJudgement {
    public static BaseBallCount judgement(String answer, String input) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < answer.length(); i++) {
            char answerChar = answer.charAt(i);
            char inputChar = input.charAt(i);
            if (answerChar == inputChar) {
                strike++;
            } else if (answer.contains(String.valueOf(inputChar))) {
                ball++;
            }
        }

        return new BaseBallCount(strike, ball);
    }
}

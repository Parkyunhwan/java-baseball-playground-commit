package baseball.first;

import java.util.stream.Collectors;

public class BaseballGame {

    public static void main(String[] args) {
        System.out.println("AA");
        BaseballGame.startBaseballGame();
    }

    final String answer;

    private BaseballGame() {
        this.answer = getRandomAnswer();
    }

    public static void startBaseballGame() {
        while (true) {
            if (!startTest()) {
                break;
            }
        }
    }

    private static boolean startTest() {
        BaseballGame baseballGame = new BaseballGame();
        while (true) {
            String input = BaseballInput.inputByConsole();
            BaseBallCount baseBallCount = baseballGame.judgementInput(input);
            System.out.println(baseBallCount.makeTextByStrikeAndBall());
            if (baseBallCount.isThreeStrike()) {
                return continueTest();
            }
        }
    }

    private static boolean continueTest() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료라면 2를 입력하세요.");
        String s = BaseballInput.inputZeroOrOne();
        return s.equals("1");
    }

    public BaseBallCount judgementInput(String input) {
        return BaseballJudgement.judgement(answer, input);
    }

    private String getRandomAnswer() {
        String randomValue = "";
        do {
            randomValue = String.valueOf((int) (Math.random() * 900) + 100);
        } while(!validateDuplication(randomValue));
        System.out.println(randomValue);
        return randomValue;
    }

    private boolean validateDuplication(String randomValue) {
        for (int i = 0; i < randomValue.length(); i++) {
            char currCh = randomValue.charAt(i);
            if (moreThanOneNumber(randomValue, currCh)) {
                return false;
            }
        }
        return true;
    }

    private boolean moreThanOneNumber(String randomValue, char currCh) {
        int cnt = 0;
        for (int i = 0; i < randomValue.length(); i++) {
            if (randomValue.charAt(i) == currCh) {
                cnt++;
            }
        }
        if (cnt > 1) {
            System.out.println("중복된 숫자가 생성되었습니다. -> " + randomValue);
            return true;
        }
        return false;
    }
}

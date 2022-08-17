package baseball.first;

public class BaseBallCount {
    private final int strike;
    private final int ball;

    public BaseBallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String makeTextByStrikeAndBall() {
        StringBuilder stringBuilder = new StringBuilder();
        if (ball > 0) {
            stringBuilder.append(ball);
            stringBuilder.append("볼 ");
        } else if (strike > 0) {
            stringBuilder.append(strike);
            stringBuilder.append("스트라이크");
        }

        if (stringBuilder.length() == 0) {
            stringBuilder.append("낫싱");
        }

        if (strike == 3) {
            stringBuilder.append("\n");
            stringBuilder.append("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        }
        return stringBuilder.toString();
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }
}

package baseball.second;

public class BallCount {
    private int strike;
    private int ball;

    public BallCount() {
    }

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void changeBallCount(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            strike++;
        } else if (ballStatus.isBall()) {
            ball++;
        }
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        if (strike > 0) {
            stringBuilder.append(strike).append("스트라이크");
        }

        if (ball > 0) {
            stringBuilder.append(ball).append("볼");
        }

        if (stringBuilder.length() == 0) {
            stringBuilder.append("낫싱");
        }
        return stringBuilder.toString();
    }
}

package baseball.second;

import java.util.Objects;

public class Ball {
    private final BallLocation ballLocation;
    private final BallNumber ballNumber;
    public Ball(int location, int value) {
        this.ballLocation = new BallLocation(location);
        ballNumber = new BallNumber(value);
    }

    public BallStatus judge(Ball otherBall) {
        if (isStrike(otherBall)) {
            return BallStatus.STRIKE;
        } else if (isBall(otherBall)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isBall(Ball otherBall) {
        return !ballLocation.equals(otherBall.ballLocation) && ballNumber.equals(otherBall.ballNumber);
    }

    private boolean isStrike(Ball otherBall) {
        return this.equals(otherBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(ballLocation, ball.ballLocation) && Objects.equals(ballNumber, ball.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballLocation, ballNumber);
    }
}

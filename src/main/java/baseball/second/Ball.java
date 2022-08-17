package baseball.second;

import java.util.Objects;

public class Ball {
    private final int location;
    private final int value;
    public Ball(int location, int value) {
        this.location = location;
        this.value = value;
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
        return location != otherBall.location && value == otherBall.value;
    }

    private boolean isStrike(Ball otherBall) {
        return this.equals(otherBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return location == ball.location && value == ball.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, value);
    }
}

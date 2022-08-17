package baseball.second;

import java.util.Objects;

public class Ball {
    private final int location;
    private final int value;
    public Ball(int location, int value) {
        this.location = location;
        this.value = value;
    }

    public String judge(Ball otherBall) {
        if (isStrike(otherBall)) {
            return "STRIKE";
        }
        return "BALL";
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

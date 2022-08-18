package baseball.second;


import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    BallStatus judgementBall(Ball userBall) {
        return balls.stream()
                .map(ball -> ball.judge(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public BallCount judgement(Balls otherBalls) {
        BallCount ballCount = new BallCount();
        for (Ball ball : balls) {
            BallStatus ballStatus = otherBalls.judgementBall(ball);
            ballCount.changeBallCount(ballStatus);
        }
        return ballCount;
    }


}

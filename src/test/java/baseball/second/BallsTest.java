package baseball.second;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {
    Balls computerBalls;
    Balls otherBall;


    @BeforeEach
    void setUp() {
        Ball ball1 = new Ball(1, 2);
        Ball ball2 = new Ball(2, 3);
        Ball ball3 = new Ball(3, 4);
        List<Ball> balls = new ArrayList<>();
        balls.add(ball1);
        balls.add(ball2);
        balls.add(ball3);
        computerBalls = new Balls(balls);
    }

    private Balls makeUserBall(Ball ball1, Ball ball2, Ball ball3) {
        List<Ball> balls = new ArrayList<>();
        balls.add(ball1);
        balls.add(ball2);
        balls.add(ball3);
        return new Balls(balls);
    }

    @Test
    void Balls와단일Ball의비교후스트라이크판단() {
        BallStatus ballStatus = computerBalls.judgementBall(new Ball(1, 2));
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void Balls와단일Ball의비교후볼판단() {
        BallStatus ballStatus = computerBalls.judgementBall(new Ball(2, 2));
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void Balls와단일Ball의비교후낫싱판단() {
        BallStatus ballStatus = computerBalls.judgementBall(new Ball(2, 5));
        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void 컴퓨터의Balls와유저의Balls비교후1스트라이크판단() {
        Ball ball1 = new Ball(1, 2);
        Ball ball2 = new Ball(2, 6);
        Ball ball3 = new Ball(3, 9);
        Balls userBalls = makeUserBall(ball1, ball2, ball3);
        BallCount ballCount = computerBalls.judgement(userBalls);
        assertThat(ballCount.print()).isEqualTo("1스트라이크");
    }

    @Test
    void 컴퓨터의Balls와유저의Balls비교후2볼판단() {
        Ball ball1 = new Ball(1, 7);
        Ball ball2 = new Ball(2, 2);
        Ball ball3 = new Ball(3, 3);
        Balls userBalls = makeUserBall(ball1, ball2, ball3);
        BallCount ballCount = computerBalls.judgement(userBalls);
        assertThat(ballCount.print()).isEqualTo("2볼");
    }

    @Test
    void 컴퓨터의Balls와유저의Balls비교후3스트라이크판단() {
        Ball ball1 = new Ball(1, 2);
        Ball ball2 = new Ball(2, 3);
        Ball ball3 = new Ball(3, 4);
        Balls userBalls = makeUserBall(ball1, ball2, ball3);
        BallCount ballCount = computerBalls.judgement(userBalls);
        assertThat(ballCount.print()).isEqualTo("3스트라이크");
    }

    @Test
    void 컴퓨터의Balls와유저의Balls비교후1스트라이크2볼판단() {
        Ball ball1 = new Ball(1, 4);
        Ball ball2 = new Ball(2, 3);
        Ball ball3 = new Ball(3, 2);
        Balls userBalls = makeUserBall(ball1, ball2, ball3);
        BallCount ballCount = computerBalls.judgement(userBalls);
        assertThat(ballCount.print()).isEqualTo("1스트라이크2볼");
    }

    @Test
    void 컴퓨터의Balls와유저의Balls비교후낫싱판단() {
        Ball ball1 = new Ball(1, 7);
        Ball ball2 = new Ball(2, 9);
        Ball ball3 = new Ball(3, 8);
        Balls userBalls = makeUserBall(ball1, ball2, ball3);
        BallCount ballCount = computerBalls.judgement(userBalls);
        assertThat(ballCount.print()).isEqualTo("낫싱");
    }
}

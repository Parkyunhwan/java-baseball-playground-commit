package baseball.second;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallTest {
    @Test
    void 체크후스트라이크판단() {
        Ball ball = new Ball(1, 3);
        Ball otherBall = new Ball(1, 3);
        Assertions.assertThat(ball.judge(otherBall)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 체크후볼판단() {
        Ball ball = new Ball(1, 3);
        Ball otherBall = new Ball(2, 3);
        Assertions.assertThat(ball.judge(otherBall)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 체크후낫싱판단() {
        Ball ball = new Ball(1, 3);
        Ball otherBall = new Ball(2, 4);
        Assertions.assertThat(ball.judge(otherBall)).isEqualTo(BallStatus.NOTHING);
    }
}

package baseball.second;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallTest {
    @Test
    void 판단후스트라이크판단() {
        Ball ball = new Ball(1, 3);
        Ball otherBall = new Ball(1, 3);
        Assertions.assertThat(ball.judge(otherBall)).isEqualTo("STRIKE");
    }
}

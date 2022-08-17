package baseball.second;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BaseballGameTest {
    @Test
    void 게임_생성_성공_테스트() {
        BaseballGame baseballGame = new BaseballGame(new ArrayList<>());
        baseballGame.play();
    }
}

package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundResultTest {

    @DisplayName("라운드 결과 값 확인")
    @Test
    void getRoundResultTest() {
        RoundResult rr = new RoundResult();
        rr.addStrike(); // 1S
        rr.addStrike(); // 2S
        rr.addBall();   // 2S 1B

        assertThat(rr.getRoundResult()).doesNotContainPattern("[3S]");

        rr.addStrike(); // 3S 1B

        assertThat(rr.getStrikeCount()).isEqualTo(3);
        assertThat(rr.getRoundResult()).containsPattern("[3S]");
    }

    @DisplayName("게임 종료 조건 확인")
    @Test
    void conditionTest() {
        RoundResult rr = new RoundResult();
        rr.addStrike(); // 1S
        rr.addStrike(); // 2S
        rr.addBall();   // 2S 1B

        assertThat(rr.isPlayCondition()).isTrue();
        assertThat(rr.isEndCondition()).isFalse();

        rr.addStrike(); // 3S 1B

        assertThat(rr.isPlayCondition()).isFalse();
        assertThat(rr.isEndCondition()).isTrue();
    }

    @DisplayName("라운드 결과 출력 확인")
    @Test
    void getRoundResult() {
        RoundResult rr = new RoundResult();
        rr.addStrike();
        rr.addStrike();
        rr.addBall();

        String expectResult = "1볼 2스트라이크";

        assertThat(rr.getRoundResult()).isEqualTo(expectResult);
    }

}
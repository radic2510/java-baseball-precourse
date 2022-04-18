package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundResultTest {

    @DisplayName("3스트라이크 확인")
    @Test
    void isEndCondition() {
        RoundResult rr = new RoundResult();
        rr.addStrike(); // 1S
        rr.addStrike(); // 2S
        rr.addBall();   // 2S 1B

        assertThat(rr.getRoundResult()).doesNotContainPattern("[3S]");

        rr.addStrike(); // 3S 1B

        assertThat(rr.getStrikeCount()).isEqualTo(3);
        assertThat(rr.getRoundResult()).containsPattern("[3S]");
    }

    @DisplayName("라운드 결과 출력 확인")
    @Test
    void getRoundResult() {
        RoundResult rr = new RoundResult();
        rr.addStrike();
        rr.addStrike();
        rr.addBall();

        String expectResult = "2스트라이크 1볼";

        assertThat(rr.getRoundResult()).isEqualTo(expectResult);
    }

}
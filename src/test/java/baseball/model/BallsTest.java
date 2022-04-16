package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class BallsTest {

    @DisplayName("문제 생성: 1~9까지 서로 다른 수로 이루어진 세 자리 숫자를 생성")
    @Test
    void createQuiz() {
        List<Integer> uniqueNumberList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        Balls quizBalls = new Balls(uniqueNumberList);

        // 세 자리 숫자가 생성되었는지 확인
        assertThat(quizBalls.isValidLength()).isTrue();

        // 각 자리 숫자가 1~9인지 확인
        for (Ball ball : quizBalls.getBallList()) {
            assertThat(ball.isValid()).isTrue();
        }

        // 각 자리 숫자가 서로 다른지 확인
        assertThat(quizBalls.isNoDuplication()).isTrue();
    }

}

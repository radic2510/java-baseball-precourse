package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class BallsTest {

    @DisplayName("문제 생성: 1~9까지 서로 다른 수로 이루어진 세 자리 숫자를 생성")
    @Test
    void createQuiz() {
        Balls quizBalls = new Balls();
        quizBalls.makeQuiz();

        // 세 자리 숫자가 생성되었는지 확인
        assertThat(quizBalls.isValidLength()).isTrue();

        // 각 자리 숫자가 1~9인지 확인
        for (Ball ball : quizBalls.getBallList()) {
            assertThat(ball.isValid()).isTrue();
        }

        // 각 자리 숫자가 서로 다른지 확인
        assertThat(quizBalls.isNoDuplication()).isTrue();
    }

    @DisplayName("두 공 리스트 비교하여 결과 확인")
    @Test
    void compareBalls() {
        List<Integer> numberList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        Balls balls1 = new Balls(numberList);
        Balls balls2 = new Balls(numberList);
        Balls balls3 = new Balls(Arrays.asList(1, 1, 1));
        RoundResult rr = new RoundResult();

        // 같은 리스트 - 3스트라이크 확인
        balls1.compareBalls(balls2, rr);
        assertThat(rr.getStrikeCount()).isEqualTo(3);

        // 다른 리스트 - 다른 결과 확인
        balls1.compareBalls(balls3, rr);
        assertThat(rr.getStrikeCount()).isEqualTo(3);
    }

}

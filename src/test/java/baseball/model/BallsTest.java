package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class BallsTest {

    @DisplayName("문제 생성: 1~9까지 서로 다른 수로 이루어진 세 자리 숫자를 생성")
    @Test
    void createQuizTest() {
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

    @DisplayName("입력(String)을 통한 Balls 생성 확인")
    @Test
    void createBallsUsingInput() {
        String input = "123";
        ConsoleHandler ch = new ConsoleHandler();
        List<Integer> inputList = ch.convertStringToList(input);

        Balls balls = new Balls(inputList);

        assertThat(balls.getBallList().size()).isEqualTo(3);
    }

    @DisplayName("두 공 리스트 비교하여 결과 확인")
    @Test
    void compareBalls() {
        List<Integer> numberList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        Balls quizBalls = new Balls(numberList);
        Balls threeStrikeBalls = new Balls(numberList);

        int ballNo = quizBalls.getBallList().get(0).getNumber();
        Balls twoBallAndOneStrikeBalls = new Balls(Arrays.asList(ballNo, ballNo, ballNo));

        // 같은 리스트 - 3스트라이크 확인
        RoundResult rr = new RoundResult();
        threeStrikeBalls.compareBalls(quizBalls, rr);
        assertThat(rr.getStrikeCount()).isEqualTo(3);

        // 다른 리스트 - 다른 결과 확인
        rr = new RoundResult();
        twoBallAndOneStrikeBalls.compareBalls(quizBalls, rr);
        assertThat(rr.getBallCount()).isEqualTo(2);
    }

}

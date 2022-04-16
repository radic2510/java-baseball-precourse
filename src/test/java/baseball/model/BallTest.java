package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

    @DisplayName("볼에 1~9 값이 들어가있는지 확인")
    @Test
    void ballValidTest() {
        Ball ball1 = new Ball(0, 6);
        assertThat(ball1.isValid()).isTrue();

        Ball ball2 = new Ball(1, 12);
        assertThat(ball2.isValid()).isFalse();
    }

}

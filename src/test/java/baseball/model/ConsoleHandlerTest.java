package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsoleHandlerTest {

    ConsoleHandler consoleHandler = new ConsoleHandler();

    @DisplayName("정상 값 검증 프로세스 확인")
    @Test
    void validationNormalCaseTest() {
        String input = "369";
        assertThat(consoleHandler.isValidAnswer(input)).isTrue();
    }

    @DisplayName("입력 값이 없는 경우 검증")
    @Test
    void validateEmptyInputTest() {
        assertThatThrownBy(getThrowingCallable(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값이 없습니다.");

        assertThatThrownBy(getThrowingCallable(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값이 없습니다.");
    }

    @DisplayName("입력 값이 숫자가 아닌 경우 검증")
    @Test
    void validateNotNumberInputTest() {
        assertThatThrownBy(getThrowingCallable("a12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1-9까지 숫자로 이루어진 3자리를 입력해야합니다.");

        assertThatThrownBy(getThrowingCallable("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1-9까지 숫자로 이루어진 3자리를 입력해야합니다.");
    }

    @DisplayName("입력 값이 3자리가 아닌 경우 검증")
    @Test
    void validateInputNumberCountTest() {
        assertThatThrownBy(getThrowingCallable("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1-9까지 숫자로 이루어진 3자리를 입력해야합니다.");

        assertThatThrownBy(getThrowingCallable("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1-9까지 숫자로 이루어진 3자리를 입력해야합니다.");
    }

    @DisplayName("입력 값에 0이 포함된 경우 검증")
    @Test
    void validateInputNumberRangeTest() {
        assertThatThrownBy(getThrowingCallable("000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1-9까지 숫자로 이루어진 3자리를 입력해야합니다.");
    }

    private ThrowingCallable getThrowingCallable(String input) {
        return () -> consoleHandler.isValidAnswer(input);
    }

}
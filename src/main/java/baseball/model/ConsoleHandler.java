package baseball.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHandler {

    public List<Integer> readAnswer() {
        return convertStringToList(readConsoleInput());
    }

    public int readSelection() {
        String input = readConsoleInput();
        validateSelectNumber(input);

        return Integer.parseInt(input);
    }

    public String readConsoleInput() {
        return Console.readLine();
    }

    public List<Integer> convertStringToList(String answer) {
        validateAnswer(answer);

        List<Integer> ls = new ArrayList<>();

        for (int i = 0; i < answer.length(); i++) {
            ls.add(Integer.parseInt(answer.substring(i, i+1)));
        }

        return ls;
    }

    public void validateAnswer(String input) {
        // 값이 없는 경우
        throwIllegalException(input == null || input.isEmpty(), "[ERROR] 입력값이 없습니다.");

        // 숫자 1~9만으로 이뤄진 3자리 문자열인지 확인
        throwIllegalException(!input.matches("^[1-9]{3}"), "[ERROR] 1-9까지 숫자로 이루어진 3자리를 입력해야합니다.");
    }

    public void validateSelectNumber(String input) {
        // 값이 없는 경우
        throwIllegalException(input == null || input.isEmpty(), "[ERROR] 입력값이 없습니다.");

        // 1 또는 2 선택지인지 확인
        throwIllegalException(!input.matches("^[12]"), "[ERROR] 1 또는 2가 아닌 값이 입력되었습니다.");
    }

    private void throwIllegalException(boolean input, String s) {
        if (input) {
            throw new IllegalArgumentException(s);
        }
    }


}

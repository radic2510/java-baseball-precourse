package baseball.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHandler {

    public String readConsoleInput() {
        return Console.readLine();
    }

    public List<Integer> convertStringToList(String answer) {
        List<Integer> ls = new ArrayList<>();

        for (int i = 0; i < answer.length(); i++) {
            ls.add(Integer.parseInt(answer.substring(i, i++)));
        }

        return ls;
    }

    public boolean isValidAnswer(String input) {
        // 값이 없는 경우
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }

        // 숫자 1~9만으로 이뤄진 3자리 문자열인지 확인
        if (!input.matches("^[1-9]{3}")) {
            throw new IllegalArgumentException("[ERROR] 1-9까지 숫자로 이루어진 3자리를 입력해야합니다.");
        }

        return true;
    }

    public boolean isValidSelectNumber(String input) {
        // 1 또는 2 선택지인지 확인
        return input.matches("^[12]");
    }


}

package baseball.model;

import java.util.*;

public class Balls {

    private List<Ball> ballList;
    private final int BALLS_SIZE = 3;

    public Balls(List<Integer> answer) {
        ballList = new ArrayList<>();

        for (int i = 0; i < answer.size(); i++) {
            ballList.add(new Ball(i, answer.get(i)));
        }
    }

    public List<Ball> getBallList() {
        return ballList;
    }

    public boolean isValidLength() {
        return ballList.size() == BALLS_SIZE;
    }

    public boolean isNoDuplication() {
        Set<Integer> set = new HashSet<>();

        for (Ball ball : ballList) {
            set.add(ball.getNumber());
        }

        return set.size() == BALLS_SIZE;
    }

}

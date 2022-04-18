package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Balls {

    private List<Ball> ballList;
    private final int BALLS_SIZE = 3;

    public Balls() {
    }

    public Balls(List<Integer> answer) {
        makeBallList(answer);
    }

    public void makeBallList(List<Integer> answer) {
        ballList = new ArrayList<>();

        for (int i = 0; i < answer.size(); i++) {
            ballList.add(new Ball(i, answer.get(i)));
        }
    }

    public void makeQuiz() {
        Set<Integer> set = new HashSet<>();

        while (set.size() != 3) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }

        makeBallList(new ArrayList<>(set));
    }

    public void compareBalls(Balls quizBalls, RoundResult result) {
        List<Ball> quizBallsList = quizBalls.getBallList();

        for (Ball ball : ballList) {
            int ballNumber = ball.getNumber();
            int ballPosition = ball.getPosition();
            Ball quizBall = quizBallsList.get(ballPosition);

            boolean isBall = isBall(ballNumber, quizBallsList);
            boolean isStrike = isStrike(ball, quizBall);

            ballStatusCheck(isBall, isStrike, result);
        }
    }

    private void ballStatusCheck(boolean isBall, boolean isStrike, RoundResult result) {
        if (isBall && !isStrike) {
            result.addBall();
        }

        if (isBall && isStrike) {
            result.addStrike();
        }
    }

    private boolean isBall(int ballNum, List<Ball> quizBallsList) {
        List<Integer> qNumbers = extractNumbersFromBallList(quizBallsList);
        return qNumbers.contains(ballNum);
    }

    private boolean isStrike(Ball ball1, Ball ball2) {
        return compareBallNumber(ball1, ball2) && compareBallPosition(ball1, ball2);
    }

    private boolean compareBallNumber(Ball ball1, Ball ball2) {
        return ball1.getNumber() == ball2.getNumber();
    }

    private boolean compareBallPosition(Ball ball1, Ball ball2) {
        return ball1.getPosition() == ball2.getPosition();
    }

    public List<Integer> extractNumbersFromBallList(List<Ball> ballList) {
        List<Integer> numbers = new ArrayList<>();

        for (Ball ball : ballList) {
            numbers.add(ball.getNumber());
        }

        return numbers;
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

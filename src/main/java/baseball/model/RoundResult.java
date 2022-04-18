package baseball.model;

public class RoundResult {

    private int strikeCount = 0;
    private int ballCount = 0;

    public boolean isPlayCondition() {
        return strikeCount != 3;
    }

    public boolean isEndCondition() {
        return strikeCount == 3;
    }

    public void printRoundResult() {
        System.out.println(getRoundResult());
    }

    public String getRoundResult() {
        StringBuilder sb = new StringBuilder();

        if (ballCount > 0) {
            sb.append(ballCount).append("볼 ");
        }

        if (strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크");
        }

        if (strikeCount <= 0 && ballCount <= 0) {
            sb.append("낫싱");
        }

        String result = sb.toString();

        return result.trim();
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void addStrike() {
        this.strikeCount++;
    }

    public void addBall() {
        this.ballCount++;
    }

}

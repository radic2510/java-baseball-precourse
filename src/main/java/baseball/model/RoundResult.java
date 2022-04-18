package baseball.model;

public class RoundResult {

    private int strikeCount = 0;
    private int ballCount = 0;

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

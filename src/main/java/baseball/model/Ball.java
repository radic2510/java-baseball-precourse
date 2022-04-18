package baseball.model;

public class Ball {

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public boolean isValid() {
        return number > 0 && number <= 9;
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

}

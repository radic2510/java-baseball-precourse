package baseball.model;

public class Ball {

    private int position;
    private int number;

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

    public void setPosition(int position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

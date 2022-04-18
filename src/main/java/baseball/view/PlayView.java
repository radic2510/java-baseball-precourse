package baseball.view;

public enum PlayView {
    GameStart("---게임 시작---\n"),
    GameEnd("---게임 종료---\n"),
    GameClear("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    RequestAnswer("숫자를 입력해주세요: "),
    RequestNewGameOrQuit("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

    private final String printMsg;

    PlayView(String printMsg) {
        this.printMsg = printMsg;
    }

    public void printMsg() {
        System.out.print(printMsg);
    }
}

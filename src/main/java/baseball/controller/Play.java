package baseball.controller;

import baseball.model.Balls;
import baseball.model.ConsoleHandler;
import baseball.model.RoundResult;
import baseball.view.PlayView;

public class Play {

    private final ConsoleHandler consoleHandler;
    private Balls quizBalls;
    private RoundResult roundResult;

    public Play() {
        consoleHandler = new ConsoleHandler();
    }

    public void initGame() {
        // 퀴즈 생성
        quizBalls = new Balls();
        quizBalls.makeQuiz();

        // 라운드 결과 초기화
        roundResult = new RoundResult();
    }

    public void playGame() {
        PlayView.GameStart.printMsg();
        initGame();

        while (roundResult.isPlayCondition()) {
            roundProcess(); // 라운드 진행
            gameEndCheck(); // 게임 종료 확인
        }

        PlayView.GameEnd.printMsg();
    }

    private void roundProcess() {
        // 라운드 결과 초기화
        roundResult = new RoundResult();

        // 플레이어 입력
        PlayView.RequestAnswer.printMsg();
        Balls answerBalls = new Balls(consoleHandler.readAnswer());

        // 결과 비교
        answerBalls.compareBalls(quizBalls, roundResult);

        // 라운드 결과 출력
        roundResult.printRoundResult();
    }

    private void gameEndCheck() {
        if (roundResult.isEndCondition()) {
            PlayView.GameClear.printMsg();
            PlayView.RequestNewGameOrQuit.printMsg();

            replayCheck(consoleHandler.readSelection());
        }
    }

    private void replayCheck(int selectedNo) {
        if (selectedNo == 1) {
            initGame();
        }
    }

}

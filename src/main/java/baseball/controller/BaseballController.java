package baseball.controller;

import baseball.BallResult;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.NumberUtils.generateRandomNumber;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private void continuePlay() {
        while (isContinuePlay(inputView.continueInput())) {
            play();
        }
    }

    public void play() {
        List<Integer> computerNumber = generateRandomNumber();

        List<Integer> input = inputView.userInput();
        BallResult ballResult = outputView.playResult(computerNumber, input);
        outputView.printResult(ballResult);

        while (!isEndGame(ballResult)) {
            input = inputView.userInput();
            ballResult = outputView.playResult(computerNumber, input);
            outputView.printResult(ballResult);
        }

        continuePlay();
    }

    private boolean isContinuePlay(Integer continuePlayFlag) {
        return continuePlayFlag.equals(1);
    }

    private boolean isEndGame(BallResult ballResult) {
        boolean isGameEnd = ballResult.isGameEnd();
        if (isGameEnd) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        return isGameEnd;
    }
}

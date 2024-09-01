package baseball.view;

import baseball.BallResult;
import baseball.Balls;

import java.io.PrintStream;
import java.util.List;

public class OutputView {
    private final PrintStream out;

    public OutputView(PrintStream sout) {
        this.out = sout;
    }

    public BallResult playResult(List<Integer> computerNumber, List<Integer> input) {
        return new Balls(computerNumber)
                .play(input);
    }

    public void printResult(BallResult ballResult) {
        boolean isExistStrike = ballResult.getStrike() > 0;
        boolean isExistBall = ballResult.getBall() > 0;
        if (isExistBall && isExistStrike) {
            out.println(ballResult.getBall() + "볼 " +
                    ballResult.getStrike() + "스트라이크 ");
            return;
        }
        if (isExistStrike) {
            out.println(ballResult.getStrike() + "스트라이크");
            return;
        }
        if (isExistBall) {
            out.println(ballResult.getBall() + "볼");
            return;
        }
        out.println("낫씽");
    }
}

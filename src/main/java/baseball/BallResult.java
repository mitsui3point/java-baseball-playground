package baseball;

import java.util.Objects;

public class BallResult {

    private int strike;
    private int ball;

    public BallResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallResult that = (BallResult) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }

    public void report(BallStatus ballStatus) {
        if (ballStatus.isBall()) {
            ball++;
        }
        if (ballStatus.isStrike()) {
            strike++;
        }
        return;
    }

    public boolean isGameEnd() {
        return strike == 3;
    }
}

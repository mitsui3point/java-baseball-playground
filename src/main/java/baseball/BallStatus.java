package baseball;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isNotNothing() {
        return !this.equals(BallStatus.NOTHING);
    }

    public boolean isStrike() {
        return this.equals(BallStatus.STRIKE);
    }

    public boolean isBall() {
        return this.equals(BallStatus.BALL);
    }
}

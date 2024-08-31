package baseball;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isNotNothing() {
        return !this.equals(BallStatus.NOTHING);
    }
}

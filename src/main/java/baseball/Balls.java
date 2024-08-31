package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls = new ArrayList<>();

    public Balls(List<Integer> ballNumbers) {
        mapBall(ballNumbers);
    }

    private void mapBall(List<Integer> ballNumbers) {
        for (int index = 0; index < ballNumbers.size(); index++) {
            Ball ball = new Ball(index + 1, ballNumbers.get(index));
            balls.add(ball);
        }
    }

    public BallStatus play(Ball targetBall) {
        return balls.stream()
                .map(targetBall::play)
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public BallResult play(List<Integer> targetBalls) {
        BallResult ballResult = new BallResult(0, 0);
        new Balls(targetBalls)
                .getBalls()
                .stream()
                .map(this::play)
                .forEach(ballResult::report);
        return ballResult;
    }

    public List<Ball> getBalls() {
        return this.balls;
    }
}

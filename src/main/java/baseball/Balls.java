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
                .map(ball -> ball.play(targetBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}

package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    private Balls answers;
    @BeforeEach
    void setUp() {
        answers = new Balls(Arrays.asList(4, 5, 2));
    }

    @Test
    @DisplayName("위치와 숫자가 같으면 STRIKE")
    void strike() {
        Ball userBall = new Ball(1, 4);
        BallStatus status = answers.play(userBall);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("위치가 다르고 숫자가 같으면 BALL")
    void ball() {
        Ball userBall = new Ball(2, 2);
        BallStatus status = answers.play(userBall);
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("위치가 다르고 숫자가 다르면 NOTHING")
    void nothing() {
        Ball userBall = new Ball(3, 6);
        BallStatus status = answers.play(userBall);
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}

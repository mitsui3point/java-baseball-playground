package baseball;

import org.junit.jupiter.api.BeforeEach;
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
    void strike() {
        BallStatus status = answers.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        BallStatus status = answers.play(new Ball(2, 2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        BallStatus status = answers.play(new Ball(3, 6));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}

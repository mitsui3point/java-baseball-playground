package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    @Test
    @DisplayName("위치와 숫자가 같으면 STRIKE")
    void strike() {
        Ball computer = new Ball(2, 4);
        Ball user = new Ball(2, 4);
        BallStatus status = computer.play(user);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("위치가 다르고 숫자가 같으면 BALL")
    void ball() {
        Ball computer = new Ball(1, 4);
        Ball user = new Ball(2, 4);
        BallStatus status = computer.play(user);
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("위치가 다르고 숫자가 다르면 NOTHING")
    void nothing() {
        Ball computer = new Ball(1, 4);
        Ball user = new Ball(2, 5);
        BallStatus status = computer.play(user);
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}

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
    @DisplayName("최종결과 3스트라이크")
    void play_3strike() {
        BallResult result = answers.play(Arrays.asList(4, 5, 2));
        BallResult expected = new BallResult(3, 0);
        assertThat(result).isEqualTo(expected);
        assertThat(result.isGameEnd()).isTrue();
    }
    @Test
    @DisplayName("최종결과 1스트라이크")
    void play_1strike() {
        BallResult result = answers.play(Arrays.asList(4, 6, 7));
        BallResult expected = new BallResult(1, 0);
        assertThat(result).isEqualTo(expected);
        assertThat(result.isGameEnd()).isFalse();
    }
    @Test
    @DisplayName("최종결과 1볼")
    void play_1ball() {
        BallResult result = answers.play(Arrays.asList(5, 9, 8));
        BallResult expected = new BallResult(0, 1);
        assertThat(result).isEqualTo(expected);
        assertThat(result.isGameEnd()).isFalse();
    }
    @Test
    @DisplayName("최종결과 낫씽")
    void play_nothing() {
        BallResult result = answers.play(Arrays.asList(1, 3, 6));
        BallResult expected = new BallResult(0, 0);
        assertThat(result).isEqualTo(expected);
        assertThat(result.isGameEnd()).isFalse();
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

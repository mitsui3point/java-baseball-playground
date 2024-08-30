package baseball;

import baseball.dto.Result;
import baseball.entity.Computer;
import baseball.entity.User;
import baseball.service.NumberCreator;
import baseball.service.PlayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballTest {

    private PlayService playService;

    @BeforeEach
    void setUp() {
        this.playService = new PlayService();
    }

    @DisplayName("야구게임 플레이 실행시, 숫자 3개를 입력하면 스트라이크 볼 낫싱을 리턴한다")
    @ParameterizedTest
    @CsvSource(value = {
            "123,713,1,1",
            "145,713,0,1",
            "671,713,0,2",
            "216,713,1,0",
            "713,713,3,0",
            "924,713,0,0",
    })
    void play(String inputNumber, String computerNumber, Integer strikeCount, Integer ballCount) {
        // given
        Computer computer = new Computer(computerNumber);
        User user = new User(inputNumber);

        // when
        Result actual = playService.play(user, computer);
        Result expected = new Result(user, computer);
        expected.setStrike(strikeCount);
        expected.setBall(ballCount);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("야구게임 플레이 실행시, 잘못된 입력값이 입력되면 오류가 발생한다")
    @ParameterizedTest
    @CsvSource(value = {
            "1234,713",
            "1ab,713",
            "3 f,713",
    })
    void playException(String inputNumber, String computerNumber) {
        assertThatThrownBy(() -> {
            // given
            Computer computer = new Computer(computerNumber);
            User user = new User(inputNumber);
            // when
            playService.play(user, computer);
        })
                // then
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~9 까지 랜덤한 숫자 3자리를 중복되지 않도록 생성한다")
    @RepeatedTest(30)
    void createRandomNumber() {
        // given
        NumberCreator numberCreator = new NumberCreator();

        // when
        String number1 = numberCreator.createNumber();
        String number2 = numberCreator.createNumber();

        Computer computer1 = new Computer(number1);
        Computer computer2 = new Computer(number2);

        Set<String> computer1CharSet = new HashSet<>(Arrays.asList(computer1.getNumber().split("")));
        Set<String> computer2CharSet = new HashSet<>(Arrays.asList(computer2.getNumber().split("")));

        // then
        assertThat(computer1.getNumber()).doesNotContain("0");
        assertThat(computer1.getNumber().length()).isEqualTo(computer1CharSet.size());
        assertThat(computer2.getNumber()).doesNotContain("0");
        assertThat(computer2.getNumber().length()).isEqualTo(computer2CharSet.size());

        assertThat(computer1.getNumber()).isNotEqualTo(computer2.getNumber());
    }
}

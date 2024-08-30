package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void splitArrays() {
        String[] actual = "1,2".split(",");
        String[] expected = {"1", "2"};
        assertThat(actual).contains(expected);
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void splitArrayOne() {
        String[] actual = "1".split(",");
        String[] expected = {"1"};
        assertThat(actual).containsExactly(expected);
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    void substring() {
        String substring = "(1,2)".substring(1, 4);
        String expected = "1,2";
        assertThat(substring).isEqualTo(expected);
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    void chatAt() {
        char actual = "abc".charAt(0);
        char expected = 'a';
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 IndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void chatAtStringIndexOutOfBoundException() {
        Assertions.assertThatThrownBy(() -> {
                    "abc".charAt(3);
                }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}

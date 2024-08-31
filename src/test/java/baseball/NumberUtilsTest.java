package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilsTest {
    @Test
    void 번호_유효성_체크_1_9() {
        assertThat(NumberUtils.numberValid(10)).isFalse();
        assertThat(NumberUtils.numberValid(9)).isTrue();
        assertThat(NumberUtils.numberValid(1)).isTrue();
        assertThat(NumberUtils.numberValid(0)).isFalse();
    }
}

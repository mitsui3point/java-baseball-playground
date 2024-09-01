package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilsTest {
    @Test
    void 번호_유효성_체크_1_9() {
        assertThat(NumberUtils.isValidDigit(10)).isFalse();
        assertThat(NumberUtils.isValidDigit(9)).isTrue();
        assertThat(NumberUtils.isValidDigit(1)).isTrue();
        assertThat(NumberUtils.isValidDigit(0)).isFalse();
    }

    @Test
    void 번호_유효성_체크_중복() {
        assertThat(NumberUtils.isValidNumber(Arrays.asList(1,2,3))).isTrue();
        assertThat(NumberUtils.isValidNumber(Arrays.asList(2,2,3))).isFalse();
    }
}

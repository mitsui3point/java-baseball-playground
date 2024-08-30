package calculator;

import calculator.exception.CalculatorException;
import calculator.service.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("계산 테스트")
    @CsvSource(value = {
            "2 + 3 * 4 / 2,10",
            "4 + 5 * 6 / 6,9",
    })
    void calculate(String formula, Integer expected) throws CalculatorException {
        Integer actual = calculator.calculate(formula);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("계산 실패 테스트")
    @CsvSource(value = {
            "2 3 3",
            "4 4 5",
            "+ 40 5",
            "+ 40 *",
    })
    void calculateFailure(String formula) {
        assertThatThrownBy(() -> {
            Integer actual = calculator.calculate(formula);
        }).isInstanceOf(CalculatorException.class);
    }
}

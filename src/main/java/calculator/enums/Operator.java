package calculator.enums;

import calculator.dto.Operand;
import calculator.exception.CalculatorException;

import java.util.function.Function;

public enum Operator {
    ADD("+", new Function<Operand, Integer>() {
        @Override
        public Integer apply(Operand operand) {
            return operand.getPrevious() + operand.getCurrent();
        }
    }),
    SUBTRACT("-", new Function<Operand, Integer>() {
        @Override
        public Integer apply(Operand operand) {
            return operand.getPrevious() - operand.getCurrent();
        }
    }),
    MULTIPLY("*", new Function<Operand, Integer>() {
        @Override
        public Integer apply(Operand operand) {
            return operand.getPrevious() * operand.getCurrent();
        }
    }),
    DIVIDE("/", new Function<Operand, Integer>() {
        @Override
        public Integer apply(Operand operand) {
            return operand.getPrevious() / operand.getCurrent();
        }
    });


    private final String value;
    private final Function<Operand, Integer> function;

    Operator(String value, Function<Operand, Integer> function) {
        this.value = value;
        this.function = function;
    }

    public static Operator extract(String operator) throws CalculatorException {
        if (operator.equals(ADD.value)) return ADD;
        if (operator.equals(SUBTRACT.value)) return SUBTRACT;
        if (operator.equals(MULTIPLY.value)) return MULTIPLY;
        if (operator.equals(DIVIDE.value)) return DIVIDE;
        throw new CalculatorException("연산자의 자리에는 +, -, *, / 만 가능합니다. 현재 연산자 자리: " + operator);
    }

    public Function<Operand, Integer> getFunction() {
        return function;
    }

    @FunctionalInterface
    public static interface Executor {
        Integer execute(Operand operand);
    }
}

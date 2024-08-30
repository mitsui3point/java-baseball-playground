package calculator.exception;

public class CalculatorException extends Throwable {
    private final String message;

    public CalculatorException(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }
}

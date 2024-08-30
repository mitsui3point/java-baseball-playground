package baseball.entity;
public class User {
    private final String input;

    public User(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력 값입니다.");
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}

package baseball.service;

public class NumberCreator {

    public String createNumber() {
        StringBuilder result = new StringBuilder();
        while (result.length() < 3) {
            addDigit(result);
        }
        return result.toString();
    }

    private void addDigit(StringBuilder result) {
        String digit = createRandomDigit();
        boolean containsResultDigit = result.toString()
                .contains(digit);
        if (!containsResultDigit) {
            result.append(digit);
        }
    }

    private String createRandomDigit() {
        int randomString = 0;
        while (randomString < 1) {
            randomString = (int) (Math.random() * 10);
        }
        return ((Integer) randomString)
                .toString();
    }
}

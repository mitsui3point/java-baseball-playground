package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class NumberUtils {

    public static boolean isValidDigit(int number) {
        return number >= 1 && number <= 9;
    }

    public static List<Integer> generateRandomNumber() {
        List<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            addDigit( result);
        }
        return result;
    }

    private static int generateDigit() {
        return Double.valueOf(Math.random() * 10)
                .intValue();
    }

    private static void addDigit( List<Integer> result) {
        int digit = generateDigit();
        if (isValidDigit(digit)) {
            result.add(digit);
        }
    }

    public static boolean isValidNumber(List<Integer> numbers) {
        int numbersSize = numbers.size();
        int numbersSetSize = new HashSet<>(numbers).size();
        return numbersSize == numbersSetSize;
    }
}

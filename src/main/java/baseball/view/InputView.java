package baseball.view;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner;
    private final PrintStream print;

    public InputView(Scanner scanner, PrintStream print) {
        this.scanner = scanner;
        this.print = print;
    }

    public List<Integer> userInput() {
        print.println("숫자를 입력해 주세요 : ");
        return getUserIntegers(scanner.next().split(""));
    }

    private List<Integer> getUserIntegers(String[] userInputs) {
        return Arrays.stream(userInputs)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer continueInput() {
        print.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextInt();
    }
}

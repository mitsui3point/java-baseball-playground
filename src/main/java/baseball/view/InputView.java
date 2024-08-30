package baseball.view;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_RESTART_LABEL = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String INPUT_NUMBER_LABEL = "숫자를 입력해 주세요 : ";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String queryRestart() {
        System.out.println(INPUT_RESTART_LABEL);// input view
        return scanner.nextLine();// input view
    }

    public String queryNumber() {
        System.out.println(INPUT_NUMBER_LABEL);// input view
        return scanner.nextLine();// input view
    }
}

package baseball;

import baseball.controller.BaseballController;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        InputStream input = System.in;
        PrintStream print = System.out;

        InputView inputView = new InputView(new Scanner(input), print);
        OutputView outputView = new OutputView(print);

        BaseballController baseballController = new BaseballController(inputView, outputView);
        baseballController.play();
    }
}

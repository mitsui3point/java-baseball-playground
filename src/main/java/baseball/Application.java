package baseball;

import baseball.service.PlayService;
import baseball.view.InputView;
import baseball.view.ResultView;
import baseball.view.View;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // baseball 랜덤생성
        final String target = "123";

        // baseball view
        Scanner scanner = new Scanner(System.in);// input view
        InputView inputView = new InputView(scanner);
        ResultView resultView = new ResultView();
        PlayService playService = new PlayService();

        View view = new View(inputView, resultView, playService);

        // baseball game view
        view.play();

        // baseball controller view
        view.restart();

    }
}

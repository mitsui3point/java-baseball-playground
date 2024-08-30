package baseball.view;

import baseball.dto.Result;
import baseball.entity.Computer;
import baseball.entity.User;
import baseball.service.NumberCreator;
import baseball.service.PlayService;

public class View {
    private final static String RESTART = "1";
    private final static String END = "2";

    private final ResultView resultView;
    private final InputView inputView;

    private final PlayService playService;


    public View(InputView inputView, ResultView resultView, PlayService playService) {
        this.resultView = resultView;
        this.inputView = inputView;
        this.playService = playService;
    }

    public void restart() {
        String input = "";
        while (!input.equals(END)) {
            input = inputView.queryRestart();
            restartPlay(input);
        }
    }

    public void play() {
        String input = "";
        Computer computer = new Computer(new NumberCreator().createNumber());
        while (!resultView.match(input, computer.getNumber())) {
            input = inputView.queryNumber();
            User user = new User(input);
            Result result = playService.play(user, computer);
            resultView.printResult(result);
        }
        resultView.printClear();

    }

    private void restartPlay(String input) {
        if (input.equals(RESTART)) {
            play();
        }
    }
}

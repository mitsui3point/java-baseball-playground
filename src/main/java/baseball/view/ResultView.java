package baseball.view;

import baseball.dto.Result;

public class ResultView {

    public static final String GAME_CLEAR_LABEL = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public boolean match(String input, String computerNumber) {
        return input.equals(computerNumber);
    }

    public void printResult(Result result) {
        String text = "";
        if (result.getBall() > 0) {
            text += result.getBall() + "볼 ";
        }
        if (result.getStrike() > 0) {
            text += result.getStrike() + "스트라이크 ";
        }
        if (text.length() == 0) {
            text = "낫싱";
        }
        System.out.println(text);
    }

    public void printClear() {
        System.out.println(GAME_CLEAR_LABEL);
    }
}

package baseball.dto;

import baseball.entity.Computer;
import baseball.entity.User;

import java.util.Objects;

public class Result {
    public static final String EMPTY_STRING_REGEX = "";
    private Integer strike;
    private Integer ball;
    private final User user;
    private final Computer computer;

    public Result(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
        this.strike = 0;
        this.ball = 0;
        compare();
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    public void compare() {
        loopOuter();
    }

    private void loopOuter() {
        Integer outer = 0;
        Integer inner = 0;
        String[] inputs = user.getInput().split(EMPTY_STRING_REGEX);
        String[] computerNumbers = computer.getNumber()
                .split(EMPTY_STRING_REGEX);

        for (String computerNumber : computerNumbers) {
            loopInner(inner, outer, inputs, computerNumber);
            inner = 0;
            outer++;
        }
    }

    private void loopInner(Integer inner, Integer outer, String[] inputs, String computerNumber) {
        for (String input : inputs) {
            addCount(inner, outer, input, computerNumber);
            inner++;
        }
    }

    private void addCount(Integer inner, Integer outer, String input, String computerNumber) {
        boolean isEqualInputNumber = computerNumber.equals(input);
        boolean isEqualsInnerOuter = inner.equals(outer);
        if (isEqualInputNumber && isEqualsInnerOuter) {
            addStrike();
            subtractBall();
        }
        if (isEqualInputNumber) {
            addBall();
        }
    }

    private void addStrike() {
        this.strike = this.strike + 1;
    }
    private void addBall() {
        this.ball = this.ball + 1;
    }
    private void subtractBall() {
        this.ball = this.ball - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(strike, result.strike) && Objects.equals(ball, result.ball);
    }
    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }

}

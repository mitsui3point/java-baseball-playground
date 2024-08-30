package baseball.service;

import baseball.dto.Result;
import baseball.entity.Computer;
import baseball.entity.User;

public class PlayService {
    public Result play(User user, Computer computer) {
        return new Result(user, computer);
    }
}

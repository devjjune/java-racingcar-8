package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {
  public static void run() {
    List<String> carList = InputHandler.getName();
    Validator.validateName(carList);

    int numberOfTries = InputHandler.getTries();
    Validator.validateInt(numberOfTries);

    Map<String, Integer> scores = GameService.initializeCarScores(carList);

    OutputView.message();
    Map<String, Integer> result = GameService.getScore(numberOfTries, scores);
    GameService.getWinner(scores);
  }
}

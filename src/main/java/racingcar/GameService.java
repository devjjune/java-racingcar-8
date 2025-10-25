package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameService {
  public static Map<String, Integer> initializeCarScores(List<String> carList) {
    Map<String, Integer> scores = new HashMap<>();
    for (int i = 0; i < carList.size(); i++) {
      scores.put(carList.get(i), 0);
    }
    return scores;
  }

  public static Map<String, Integer> getScore(int numberOfTries, Map<String, Integer> scores) {
    for (int i = 0; i < numberOfTries; i++) {
      tryOneTime(scores);
      OutputView.printResult(scores);
    }
    return scores;
  }

  public static Map<String, Integer> tryOneTime(Map<String, Integer> scores) {
    for (String eachCar : scores.keySet()) {
      int eachScore = scores.get(eachCar);
      eachScore = plusRandomNumber(eachScore);
      scores.put(eachCar, eachScore);
    }
    return scores;
  }

  public static int plusRandomNumber(int eachScore) {
    int randomNumber = Randoms.pickNumberInRange(0, 9);
    if (randomNumber >= 4) {
      eachScore += 1;
    }
    return eachScore;
  }

  public static void getWinner(Map<String, Integer> scores) {
    int maxScore = Collections.max(scores.values());
    List<String> winners = new ArrayList<>();

    for (Map.Entry<String, Integer> entry : scores.entrySet()) {
      GameService.addIfMaxScore(entry, maxScore, winners);
    }

    OutputView.printWinner(winners);
  }

  public static void addIfMaxScore(
      Map.Entry<String, Integer> entry, int maxScore, List<String> winners) {
    if (entry.getValue() == maxScore) {
      winners.add(entry.getKey());
    }
  }
}

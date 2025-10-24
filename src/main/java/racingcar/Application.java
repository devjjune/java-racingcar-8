package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
  public static void main(String[] args) {
    List<String> carList = getName();
    int numberOfTries = getTries();
    Map<String, Integer> scores = initializeCarScores(carList);
    Map<String, Integer> result = getScore(numberOfTries, scores);
  }

  public static List<String> getName() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String inputName = Console.readLine();
    String[] carArray = inputName.split(",");

    return new ArrayList<>(List.of(carArray));
  }

  public static int getTries() {
    System.out.println("시도할 횟수는 몇 회인가요?");
    String inputTries = Console.readLine();

    return Integer.parseInt(inputTries);
  }

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
}

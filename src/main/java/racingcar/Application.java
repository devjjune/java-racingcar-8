package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
  public static void main(String[] args) {
    List<String> carList = getName();
    int numberOfTries = getTries();
    Map<String, Integer> scores = initializeCarScores(carList);

    System.out.println("실행 결과");
    Map<String, Integer> result = getScore(numberOfTries, scores);
    System.out.println();
    printWinner(scores);
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
      printResult(scores);
      System.out.println();
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

  public static void printResult(Map<String, Integer> scores) {
    for (String eachCar : scores.keySet()) {
      int eachScore = scores.get(eachCar);
      System.out.println(eachCar + " : " + "-".repeat(eachScore));
    }
  }

  public static void printWinner(Map<String, Integer> scores) {
    int maxScore = Collections.max(scores.values());
    List<String> winners = new ArrayList<>();

    for (Map.Entry<String, Integer> entry : scores.entrySet()) {
      addIfMaxScore(entry, maxScore, winners);
    }

    System.out.println("최종 우승자 : " + String.join(", ", winners));
  }

  public static void addIfMaxScore(
      Map.Entry<String, Integer> entry, int maxScore, List<String> winners) {
    if (entry.getValue() == maxScore) {
      winners.add(entry.getKey());
    }
  }

  public static void validateName(String input) {
    if (input.isBlank()) {
      throw new IllegalArgumentException("자동차 이름을 입력하세요.");
    }

    String[] carNames = input.split(",");
    for (String name : carNames) {
      if (name.length() > 5) {
        throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력하세요.");
      }
    }
    if (carNames.length == 0) {
      throw new IllegalArgumentException("하나 이상의 이름을 입력하세요.");
    }
  }

  public static void validateInt(String input) {
    if (!input.matches("\\d+")) {
      throw new IllegalArgumentException("숫자를 입력해야 합니다.");
    }

    int number = Integer.parseInt(input);
    if (number <= 0) {
      throw new IllegalArgumentException("1 이상의 정수를 입력하세요.");
    }
  }
}

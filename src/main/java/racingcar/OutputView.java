package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
  public static void printStartMessage() {
    System.out.println("실행 결과");
  }

  public static void printResult(Map<String, Integer> carPositions) {
    for (String eachCar : carPositions.keySet()) {
      int eachScore = carPositions.get(eachCar);
      System.out.println(eachCar + " : " + "-".repeat(eachScore));
    }

    System.out.println();
  }

  public static void printWinner(List<String> winnersName) {
    System.out.println();
    System.out.println("최종 우승자 : " + String.join(", ", winnersName));
  }
}

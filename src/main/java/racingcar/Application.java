package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
  public static void main(String[] args) {
    List<String> participantList = getName();
    int numberOfTries = getTries();
  }

  public static List<String> getName() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String participantName = Console.readLine();
    String[] participantArray = participantName.split(",");

    return new ArrayList<>(List.of(participantArray));
  }

  public static int getTries() {
    System.out.println("시도할 횟수는 몇 회인가요?");
    String inputTries = Console.readLine();

    return Integer.parseInt(inputTries);
  }
}

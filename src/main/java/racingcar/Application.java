package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
  public static void main(String[] args) {
    GameController.run();
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

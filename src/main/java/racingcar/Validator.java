package racingcar;

import java.util.List;

public class Validator {
  public static void validateName(List<String> carNameList) {
    if (carNameList.isEmpty()) {
      throw new IllegalArgumentException("자동차 이름을 입력하세요.");
    }

    for (String name : carNameList) {
      if (name.length() > 5) {
        throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력하세요.");
      }
    }
    if (carNameList.size() == 1) {
      throw new IllegalArgumentException("두개 이상의 이름을 입력하세요.");
    }
  }

  public static void validateInt(int input) {
    if (input <= 0) {
      throw new IllegalArgumentException("1 이상의 정수를 입력하세요.");
    }
  }
}

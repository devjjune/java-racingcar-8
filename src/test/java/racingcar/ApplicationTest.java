package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

  @Test
  @DisplayName("랜덤값이 4와 3일 때, pobi는 전진하고 woni는 멈춘다.")
  void carMovesOnlyWhenRandomOverFour() {
    assertRandomNumberInRangeTest(
        () -> {
          run("pobi,woni", "1");
          assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
        },
        4,
        3);
  }

  @Test
  @DisplayName("랜덤값이 6과 9일 때, pobi와 woni 모두 전진한다.")
  void bothCarsMovesWhenRandomOverFour() {
    assertRandomNumberInRangeTest(
        () -> {
          run("pobi,woni", "1");
          assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
        },
        6,
        9);
  }

  @Test
  @DisplayName("랜덤값이 1과 3일 때, pobi와 woni 모두 멈춘다.")
  void bothCarsStopWHenRandomUnderFour() {
    assertRandomNumberInRangeTest(
        () -> {
          run("pobi,woni", "1");
          assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
        },
        1,
        3);
  }

  @Test
  @DisplayName("5자 이상의 이름을 입력 시 예외가 발생한다.")
  void throwsExceptionWhenNameExceedsLimit() {
    assertSimpleTest(
        () ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class));
  }

  @Override
  public void runMain() {
    Application.main(new String[] {});
  }
}

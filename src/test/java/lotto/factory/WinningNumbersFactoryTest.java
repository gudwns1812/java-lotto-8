package lotto.factory;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersFactoryTest {

    @ParameterizedTest
    @MethodSource("LottoAndBonusNumber")
    void 당첨번호와_보너스번호가_중복되면_안된다(Lotto main, String bonus) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningNumbersFactory.createWinningNumbers(main, bonus));
    }

    @ParameterizedTest
    @MethodSource("LottoNumberIsNegative")
    void 당첨번호가_0이하이면_안된다(Lotto main, String bonus) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningNumbersFactory.createWinningNumbers(main, bonus));
    }

    static Stream<Arguments> LottoAndBonusNumber() {
        return Stream.of(
                Arguments.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), "1"),
                Arguments.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), "2")
        );
    }

    static Stream<Arguments> LottoNumberIsNegative() {
        return Stream.of(
                Arguments.arguments(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), "-1"),
                Arguments.arguments(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), "0")
        );
    }
}

package lotto.factory;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumbersFactoryTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1,1,2,3,4:1", "1,2,3,4,5,6:5"}, delimiter = ':')
    void 당첨번호와_보너스번호가_중복되면_안된다(String main, String bonus) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningNumbersFactory.createWinningNumbers(main, bonus));
    }

    @ParameterizedTest
    @CsvSource(value = {"-1,0,1,2,3,4:1", "1,2,3,4,5,6:-1"}, delimiter = ':')
    void 당첨번호가_0이하이면_안된다(String main, String bonus) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningNumbersFactory.createWinningNumbers(main, bonus));
    }
}

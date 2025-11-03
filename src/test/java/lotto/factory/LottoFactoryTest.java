package lotto.factory;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    @Test
    void 문자열_마지막에_구분자로_끝나는경우_예외를_터트린다() {
        //given
        String input = "1,2,3,4,5,6,";
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoFactory.createLotto(input));
    }

    @Test
    void 문자열이_빈_문자열일_경우_예외를_터트린다() {
        //given
        String input = "";
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoFactory.createLotto(input));
    }
}

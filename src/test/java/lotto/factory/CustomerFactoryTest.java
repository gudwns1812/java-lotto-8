package lotto.factory;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CustomerFactoryTest {

    @Test
    void 입력값이_1000으로_나누어_떨어지지_않으면_예외를_터트린다() {
        //given
        String input = "8800";
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CustomerFactory.createCustomerWith(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000"})
    void 입력값이_0이하면_예외를_터트린다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CustomerFactory.createCustomerWith(input));
    }

    @Test
    void 입력값이_숫자가_아니면_예외를_터트린다() {
        //given
        String input = "aaa";
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CustomerFactory.createCustomerWith(input));
    }

}

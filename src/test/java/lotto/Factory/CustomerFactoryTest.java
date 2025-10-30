package lotto.Factory;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

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

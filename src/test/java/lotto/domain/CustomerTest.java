package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.numbergenerator.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

    private Customer customer;
    private LottoSeller seller;

    @BeforeEach
    void setUp() {
        seller = new LottoSeller(new RandomGenerator());
        customer = Customer.with(6000);
    }

    @Test
    void Customer는_금액에_따라_로또를_살수있다() {
        //given
        //when
        List<List<Integer>> numbers = customer.buyLottoFrom(seller);
        //then
        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void Lotto_내부값들은_전부_오름차순이다() {
        //given
        //when
        List<List<Integer>> numbers = customer.buyLottoFrom(seller);
        List<Integer> first = numbers.getFirst();
        //then
        for (int i = 0; i < first.size() - 1; i++) {
            assertThat(first.get(i)).isLessThanOrEqualTo(first.get(i + 1));
        }
    }
}

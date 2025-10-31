package lotto.domain;

import static lotto.Factory.WinningNumbersFactory.createWinningNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.numbergenerator.FixedGenerator;
import lotto.domain.numbergenerator.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

    private Customer customer;
    private LottoSeller seller;

    @BeforeEach
    void setUp() {
        customer = Customer.with(6000);
    }

    @Test
    void Customer는_금액에_따라_로또를_살수있다() {
        //given
        seller = new LottoSeller(new RandomGenerator());
        //when
        List<List<Integer>> numbers = customer.buyLottoFrom(seller);
        //then
        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void Lotto_내부값들은_전부_오름차순이다() {
        //given
        seller = new LottoSeller(new RandomGenerator());
        //when
        List<List<Integer>> numbers = customer.buyLottoFrom(seller);
        List<Integer> first = numbers.getFirst();
        //then
        for (int i = 0; i < first.size() - 1; i++) {
            assertThat(first.get(i)).isLessThanOrEqualTo(first.get(i + 1));
        }
    }

    @Test
    void customer가_WinningNumber와_숫자를_비교해_Rank_를_반환한다() {
        //given
        List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 6);
        seller = new LottoSeller(new FixedGenerator(userLotto));
        customer.buyLottoFrom(seller);

        String mainInput = "1,2,3,4,5,7";
        String bonusInput = "6";
        //when
        Map<Rank, Long> rankStatics = customer.getRankStatics(createWinningNumbers(mainInput, bonusInput));
        //then
        assertThat(rankStatics.keySet())
                .containsExactly(Rank.SECOND_PLACE);
    }
}

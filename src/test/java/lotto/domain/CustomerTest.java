package lotto.domain;

import static lotto.factory.WinningNumbersFactory.createWinningNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.numbergenerator.FixedGenerator;
import lotto.domain.numbergenerator.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {
    private static final int PERCENT = 100;

    private Customer customer;
    private LottoSeller seller;

    @BeforeEach
    void setUp() {
        customer = Customer.with(5000);
    }

    @Test
    void Customer는_금액에_따라_로또를_살수있다() {
        //given
        seller = new LottoSeller(new RandomGenerator());
        //when
        List<List<Integer>> numbers = customer.buyLottoFrom(seller);
        //then
        assertThat(numbers.size()).isEqualTo(5);
    }

    @Test
    void customer가_WinningNumber와_숫자를_비교해_Rank_를_반환한다() {
        //given
        List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 6);
        seller = new LottoSeller(new FixedGenerator(userLotto));
        customer.buyLottoFrom(seller);

        Lotto mainInput = Lotto.from(List.of(1, 2, 3, 4, 5, 7));
        String bonusInput = "6";
        //when
        Map<Rank, Long> rankStatics = customer.getRankStatics(createWinningNumbers(mainInput, bonusInput));
        //then
        assertThat(rankStatics.keySet())
                .containsExactly(Rank.SECOND_PLACE);
    }

    @Test
    @DisplayName("customer의 calculateProfitRate 메서드를 활용해 수익률을 계산한다.")
    void profitRate_계산_테스트() {
        //given
        List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 6);
        seller = new LottoSeller(new FixedGenerator(userLotto));
        customer.buyLottoFrom(seller);

        Lotto mainInput = Lotto.from(List.of(1, 2, 3, 4, 5, 7));
        String bonusInput = "6";

        long totalPrize = Rank.SECOND_PLACE.getPrize().getValue();
        long totalCost = 1000;
        double expectedProfitRate = (double) (totalPrize * PERCENT) / totalCost;
        //when
        double profitRate = customer.calculateProfitRate(createWinningNumbers(mainInput, bonusInput));
        //then
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}

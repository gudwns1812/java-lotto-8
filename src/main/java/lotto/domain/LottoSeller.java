package lotto.domain;

import static lotto.domain.LottoLimitNumbers.LOTTO_PRICE;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.numbergenerator.NumberGenerator;

public class LottoSeller {

    private final NumberGenerator numberGenerator;

    public LottoSeller(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createLottoWithin(int cash) {
        int lottoCount = cash / LOTTO_PRICE.getValue();
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(numberGenerator.generateNumbers()))
                .toList();
    }
}

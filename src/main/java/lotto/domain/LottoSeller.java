package lotto.domain;

import java.util.List;
import java.util.stream.LongStream;
import lotto.domain.numbergenerator.NumberGenerator;

public class LottoSeller {

    private final NumberGenerator numberGenerator;

    public LottoSeller(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createLottoWithin(Money cash) {
        long lottoCount = cash.calculateLottoCount();
        return LongStream.range(0, lottoCount)
                .mapToObj(i -> Lotto.from(numberGenerator.generateNumbers()))
                .toList();
    }
}

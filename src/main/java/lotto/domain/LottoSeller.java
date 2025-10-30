package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.numbergenerator.NumberGenerator;

public class LottoSeller {

    private final NumberGenerator numberGenerator;

    public LottoSeller(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createLottoWithin(int cash) {
        return IntStream.rangeClosed(0, cash)
                .mapToObj(i -> new Lotto(numberGenerator.generateNumbers()))
                .toList();
    }
}

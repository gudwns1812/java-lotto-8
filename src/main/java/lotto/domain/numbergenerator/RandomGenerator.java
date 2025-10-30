package lotto.domain.numbergenerator;

import static lotto.domain.LottoLimitNumbers.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.LottoLimitNumbers.MAX_LOTTO_SIZE;
import static lotto.domain.LottoLimitNumbers.MINIMUM_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomGenerator implements NumberGenerator {
    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                MINIMUM_LOTTO_NUMBER.getValue(),
                MAXIMUM_LOTTO_NUMBER.getValue(),
                MAX_LOTTO_SIZE.getValue());
    }
}

package lotto.domain;

import static lotto.domain.LottoLimitNumbers.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.LottoLimitNumbers.MAX_LOTTO_SIZE;
import static lotto.domain.LottoLimitNumbers.MINIMUM_LOTTO_NUMBER;
import static lotto.exception.ErrorMessage.DUPLICATE_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;

public class WinningNumbers {
    private static final int BONUS_NUMBER_COUNT = 1;

    private final Lotto winningLotto;
    private final int bonusNumber;

    private WinningNumbers(List<Integer> mainNumbers, int bonusNumber) {
        validateDuplicateNumbers(mainNumbers, bonusNumber);
        validateLottoNumbers(mainNumbers);
        validateSingleNumber(bonusNumber);

        this.winningLotto = Lotto.from(mainNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumbers(List<Integer> mainNumbers, int bonusNumber) {
        Set<Integer> set = new HashSet<>(mainNumbers);
        set.add(bonusNumber);

        if (set.size() != (MAX_LOTTO_SIZE.getValue() + BONUS_NUMBER_COUNT)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateLottoNumbers(List<Integer> mainNumbers) {
        mainNumbers.forEach(this::validateSingleNumber);
    }

    private void validateSingleNumber(int singleNumber) {
        if (singleNumber < MINIMUM_LOTTO_NUMBER.getValue() || singleNumber > MAXIMUM_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER.getMessage());
        }
    }

    public static WinningNumbers of(List<Integer> mainNumbers, int bonusNumber) {
        return new WinningNumbers(mainNumbers, bonusNumber);
    }

    public List<Rank> evaluateLottoRanks(List<Lotto> userLottos) {
        return userLottos.stream()
                .map(lotto -> lotto.evaluateRank(winningLotto, bonusNumber))
                .toList();
    }
}

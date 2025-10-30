package lotto.domain;

import static lotto.domain.LottoLimitNumbers.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.LottoLimitNumbers.MINIMUM_LOTTO_NUMBER;
import static lotto.exception.ErrorMessage.DUPLICATE_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;

public class WinningNumbers {
    private static final int MAIN_NUMBER = 1;
    private static final int BONUS_NUMBER = 2;
    private static final int BONUS_NUMBER_COUNT = 1;

    private final int[] numberMap;

    private WinningNumbers(List<Integer> mainNumbers, int bonusNumber) {
        numberMap = new int[MAXIMUM_LOTTO_NUMBER.getValue() + 1];

        validateDuplicateNumbers(mainNumbers, bonusNumber);
        validateLottoNumbers(mainNumbers);
        validateSingleNumber(bonusNumber);

        settingWinningNumbers(mainNumbers);
        settingBonusNumber(bonusNumber);
    }

    private void validateDuplicateNumbers(List<Integer> mainNumbers, int bonusNumber) {
        Set<Integer> set = new HashSet<>(mainNumbers);
        set.add(bonusNumber);

        if (set.size() != mainNumbers.size() + BONUS_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateLottoNumbers(List<Integer> mainNumbers) {
        mainNumbers.forEach(this::validateSingleNumber);
    }

    private void validateSingleNumber(int bonusNumber) {
        if (bonusNumber < MINIMUM_LOTTO_NUMBER.getValue() || bonusNumber > MAXIMUM_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER.getMessage());
        }
    }

    private void settingWinningNumbers(List<Integer> numbers) {
        numbers.forEach(number -> numberMap[number] = MAIN_NUMBER);
    }

    private void settingBonusNumber(int number) {
        numberMap[number] = BONUS_NUMBER;
    }

    public static WinningNumbers of(List<Integer> mainNumbers, int bonusNumber) {
        return new WinningNumbers(mainNumbers, bonusNumber);
    }
}

package lotto.factory;

import static lotto.domain.LottoLimitNumbers.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.LottoLimitNumbers.MINIMUM_LOTTO_NUMBER;
import static lotto.util.NumberConverter.parseInt;

import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.exception.ErrorMessage;

public class WinningNumbersFactory {

    public static WinningNumbers createWinningNumbers(Lotto lotto, String bonusInput) {
        int bonusNumber = parseInt(bonusInput);
        validateLottoNumber(bonusNumber);

        if (lotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }

        return WinningNumbers.of(lotto, bonusNumber);
    }

    private static void validateLottoNumber(int singleNumber) {
        if (singleNumber < MINIMUM_LOTTO_NUMBER.getValue() || singleNumber > MAXIMUM_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER.getMessage());
        }
    }
}

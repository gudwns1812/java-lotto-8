package lotto.Factory;

import static lotto.util.NumberConverter.parseInt;

import java.util.List;
import lotto.domain.WinningNumbers;
import lotto.util.NumberConverter;

public class WinningNumbersFactory {
    private static final String NUMBER_DELIMITER = ",";

    public static WinningNumbers createWinningNumbers(String mainNumber, String bonusNumber) {
        List<String> mainNumbers = List.of(mainNumber.split(NUMBER_DELIMITER));

        List<Integer> main = mainNumbers.stream()
                .map(NumberConverter::parseInt)
                .toList();

        int bonus = parseInt(bonusNumber);

        return WinningNumbers.of(main, bonus);
    }
}

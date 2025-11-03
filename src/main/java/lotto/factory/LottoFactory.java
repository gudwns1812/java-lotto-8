package lotto.factory;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.NumberConverter;

public class LottoFactory {
    private static final String NUMBER_DELIMITER = ",";
    private static final int VALIDATE_SPLIT_LIMIT = -1;

    public static Lotto createLotto(String lottoInput) {
        List<String> lottoNumbers = List.of(lottoInput.split(NUMBER_DELIMITER, VALIDATE_SPLIT_LIMIT));

        List<Integer> lotto = lottoNumbers.stream()
                .map(NumberConverter::parseInt)
                .toList();

        return Lotto.from(lotto);
    }
}

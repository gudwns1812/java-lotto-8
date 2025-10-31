package lotto.view.printer;

import java.util.List;
import java.util.Map;
import lotto.domain.Rank;

public interface Printer {
    void printEnterUserFee();

    void printErrorMessage(String message);

    void printLottoNumbers(List<List<Integer>> LottoNumbers);

    void printEnterWinningNumber();

    void printEnterBonusNumber();

    void printLottoStatics(Map<Rank, Long> rankStatics, double profitRate);
}

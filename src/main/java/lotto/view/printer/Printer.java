package lotto.view.printer;

import java.util.List;

public interface Printer {
    void printEnterUserFee();

    void printErrorMessage(String message);

    void printLottoNumbers(List<List<Integer>> LottoNumbers);
}

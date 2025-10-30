package lotto.view.printer;

import lotto.exception.ErrorMessage;

public interface Printer {
    void printEnterUserFee();

    void printErrorMessage(ErrorMessage error);
}

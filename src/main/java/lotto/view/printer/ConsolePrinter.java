package lotto.view.printer;

import static lotto.view.printer.PrintMessage.USER_FEE_MESSAGE;

import lotto.exception.ErrorMessage;

public class ConsolePrinter implements Printer {
    @Override
    public void printEnterUserFee() {
        System.out.println(USER_FEE_MESSAGE);
    }

    @Override
    public void printErrorMessage(ErrorMessage message) {
        System.out.println(message);
    }
}

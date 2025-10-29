package lotto.view.printer;

import static lotto.view.printer.PrintMessage.USER_FEE_MESSAGE;

public class ConsolePrinter implements Printer {
    @Override
    public void printEnterUserFee() {
        System.out.println(USER_FEE_MESSAGE);
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}

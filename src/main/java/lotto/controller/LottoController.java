package lotto.controller;

import static lotto.exception.ErrorMessage.NOT_NUMBER;

import lotto.view.printer.Printer;
import lotto.view.reader.Reader;

public class LottoController {
    private final Reader reader;
    private final Printer printer;

    public LottoController(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public void run() {
        printer.printEnterUserFee();
        String fee = reader.readUserFee();
        int userFee = parseInt(fee);
    }

    private int parseInt(String fee) {
        try {
            return Integer.parseInt(fee);
        } catch (NumberFormatException e) {
            printer.printErrorMessage(NOT_NUMBER);
            return 0;
        }
    }
}

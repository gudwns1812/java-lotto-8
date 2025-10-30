package lotto.controller;

import static lotto.exception.ErrorMessage.NOT_MULTIPLE_OF_1000;
import static lotto.exception.ErrorMessage.NOT_NUMBER;

import lotto.service.LottoService;
import lotto.view.printer.Printer;
import lotto.view.reader.Reader;

public class LottoController {
    private final Reader reader;
    private final Printer printer;
    private final LottoService lottoService;

    public LottoController(Reader reader, Printer printer, LottoService lottoService) {
        this.reader = reader;
        this.printer = printer;
        this.lottoService = lottoService;
    }

    public void run() {
        processGenerateLotto();
    }

    private void processGenerateLotto() {
        while (true) {
            try {
                printer.printEnterUserFee();
                String fee = reader.readUserFee();
                int userFee = parseInt(fee);
            } catch (IllegalArgumentException e) {
                printer.printErrorMessage(NOT_MULTIPLE_OF_1000);
            }
        }
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

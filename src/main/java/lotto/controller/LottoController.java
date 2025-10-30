package lotto.controller;

import java.util.List;
import lotto.Factory.CustomerFactory;
import lotto.domain.Customer;
import lotto.domain.LottoSeller;
import lotto.view.printer.Printer;
import lotto.view.reader.Reader;

public class LottoController {
    private final Reader reader;
    private final Printer printer;
    private final LottoSeller lottoSeller;

    public LottoController(Reader reader, Printer printer, LottoSeller seller) {
        this.reader = reader;
        this.printer = printer;
        this.lottoSeller = seller;
    }

    public void run() {
        Customer customer = processGenerateLotto();
    }

    private Customer processGenerateLotto() {
        while (true) {
            try {
                printer.printEnterUserFee();
                String fee = reader.readUserFee();

                Customer customer = CustomerFactory.createCustomerWith(fee);
                List<List<Integer>> customerLottos = customer.buyLottoFrom(lottoSeller);
                printer.printLottoNumbers(customerLottos);
                return customer;
            } catch (IllegalArgumentException e) {
                printer.printErrorMessage(e.getMessage());
            }
        }
    }
}

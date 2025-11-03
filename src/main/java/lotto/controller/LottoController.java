package lotto.controller;

import static lotto.factory.CustomerFactory.createCustomerWith;
import static lotto.factory.WinningNumbersFactory.createWinningNumbers;

import java.util.List;
import java.util.Map;
import lotto.domain.Customer;
import lotto.domain.LottoSeller;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
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
        Customer customer = customerWithGenerateLotto();
        WinningNumbers winningNumbers = readWinningNumbers();
        processFinalResult(customer, winningNumbers);
    }

    private Customer customerWithGenerateLotto() {
        while (true) {
            try {
                printer.printEnterUserFee();
                String fee = reader.readUserFee();

                Customer customer = createCustomerWith(fee);
                List<List<Integer>> customerLottos = customer.buyLottoFrom(lottoSeller);

                printer.printLottoNumbers(customerLottos);
                return customer;
            } catch (IllegalArgumentException e) {
                printer.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumbers readWinningNumbers() {
        while (true) {
            try {
                printer.printEnterWinningNumber();
                String mainNumber = reader.readWinningMainNumbers();

                printer.printEnterBonusNumber();
                String bonusNumber = reader.readWinningBonusNumber();

                return createWinningNumbers(mainNumber, bonusNumber);
            } catch (IllegalArgumentException e) {
                printer.printErrorMessage(e.getMessage());
            }
        }
    }

    private void processFinalResult(Customer customer, WinningNumbers winningNumbers) {
        Map<Rank, Long> rankStatics = customer.getRankStatics(winningNumbers);
        double profitRate = customer.calculateProfitRate(winningNumbers);

        printer.printFinalResult(rankStatics, profitRate);
    }
}

package lotto.controller;

import static lotto.factory.CustomerFactory.createCustomerWith;
import static lotto.factory.LottoFactory.createLotto;
import static lotto.factory.WinningNumbersFactory.createWinningNumbers;

import java.util.List;
import java.util.Map;
import lotto.domain.Customer;
import lotto.domain.Lotto;
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
                String mainNumber = readMainNumbers();
                Lotto lotto = createLotto(mainNumber);

                String bonusNumber = readBonusNumber();
                return createWinningNumbers(lotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                printer.printErrorMessage(e.getMessage());
            }
        }
    }

    private String readMainNumbers() {
        printer.printEnterWinningNumber();
        return reader.readWinningMainNumbers();
    }

    private String readBonusNumber() {
        printer.printEnterBonusNumber();
        return reader.readWinningBonusNumber();
    }

    private void processFinalResult(Customer customer, WinningNumbers winningNumbers) {
        Map<Rank, Long> rankStatics = customer.getRankStatics(winningNumbers);
        double profitRate = customer.calculateProfitRate(winningNumbers);

        printer.printFinalResult(rankStatics, profitRate);
    }
}

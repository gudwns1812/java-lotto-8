package lotto.domain;

import static lotto.exception.ErrorMessage.NOT_MULTIPLE_OF_1000;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Customer {

    private final Money cash;
    private List<Lotto> userLottos;

    private Customer(Money cash) {
        this.cash = cash;
    }

    public static Customer with(int cash) {
        validateCorrectCash(cash);
        return new Customer(Money.won(cash));
    }

    private static void validateCorrectCash(int cash) {
        if (cash % 1000 != 0) {
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_1000.getMessage());
        }
    }

    public List<List<Integer>> buyLottoFrom(LottoSeller lottoSeller) {
        userLottos = lottoSeller.createLottoWithin(cash);

        return userLottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    public Map<Rank, Long> getRankStatics(WinningNumbers winningNumbers) {
        List<Rank> lottoRanks = winningNumbers.evaluateLottoRanks(userLottos);

        return lottoRanks.stream()
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    public double calculateProfitRate(WinningNumbers winningNumbers) {
        List<Rank> lottoRanks = winningNumbers.evaluateLottoRanks(userLottos);

        Money prize = lottoRanks.stream()
                .map(Rank::getPrize)
                .reduce(Money::plus)
                .orElse(Money.ZERO);

        return prize.divideBy(cash);
    }
}

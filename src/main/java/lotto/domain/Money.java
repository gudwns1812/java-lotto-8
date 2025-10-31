package lotto.domain;

import static lotto.domain.LottoLimitNumbers.LOTTO_PRICE;

public class Money {
    public static final Money ZERO = Money.won(0);
    private static final int PERCENT = 100;

    private final long amount;

    private Money(long amount) {
        this.amount = amount;
    }

    public static Money won(long money) {
        return new Money(money);
    }

    public long calculateLottoCount() {
        return amount / LOTTO_PRICE.getValue();
    }

    public Money plus(Money money) {
        return new Money(amount + money.amount);
    }

    public double divideBy(Money cash) {
        return (double) amount / (cash.amount * PERCENT);
    }

    public long getValue() {
        return amount;
    }
}

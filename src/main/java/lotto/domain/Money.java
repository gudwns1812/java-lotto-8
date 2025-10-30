package lotto.domain;

import static lotto.domain.LottoLimitNumbers.LOTTO_PRICE;

public class Money {
    private final int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money won(int money) {
        return new Money(money);
    }

    public int calculateLottoCount() {
        return amount / LOTTO_PRICE.getValue();
    }

    public int getValue() {
        return amount;
    }
}

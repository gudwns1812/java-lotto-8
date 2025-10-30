package lotto.domain;

public enum LottoLimitNumbers {
    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45),
    MAX_LOTTO_SIZE(6),
    LOTTO_PRICE(1000);

    private final int value;

    LottoLimitNumbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

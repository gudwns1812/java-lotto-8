package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NONE_PLACE(0, false, 0),
    FIFTH_PLACE(3, false, 5_000),
    FOURTH_PLACE(4, false, 50_000),
    THIRD_PLACE(5, false, 1_500_000),
    SECOND_PLACE(5, true, 30_000_000),
    FIRST_PLACE(6, false, 2_000_000_000);

    private final int correctCount;
    private final boolean hasBonus;
    private final Money prize;

    Rank(int score, boolean hasBonus, long prize) {
        this.correctCount = score;
        this.hasBonus = hasBonus;
        this.prize = Money.won(prize);
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    public Money getPrize() {
        return prize;
    }

    public static Rank from(int count, boolean bonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.correctCount == count && rank.hasBonus == bonus)
                .findFirst()
                .orElse(NONE_PLACE);
    }
}

package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    private WinningNumbers(Lotto mainNumbers, int bonusNumber) {
        this.winningLotto = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(Lotto mainNumbers, int bonusNumber) {
        return new WinningNumbers(mainNumbers, bonusNumber);
    }

    public List<Rank> evaluateLottoRanks(List<Lotto> userLottos) {
        return userLottos.stream()
                .map(lotto -> lotto.evaluateRank(winningLotto, bonusNumber))
                .toList();
    }
}

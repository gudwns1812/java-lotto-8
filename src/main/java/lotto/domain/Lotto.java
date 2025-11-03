package lotto.domain;

import static lotto.domain.LottoLimitNumbers.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.LottoLimitNumbers.MAX_LOTTO_SIZE;
import static lotto.domain.LottoLimitNumbers.MINIMUM_LOTTO_NUMBER;
import static lotto.exception.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.exception.ErrorMessage.NOT_LOTTO_NUMBER;
import static lotto.exception.ErrorMessage.NOT_LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumber(numbers);
        validateLottoNumbers(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(NOT_LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);

        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        numbers.forEach(this::validateSingleNumber);
    }

    private void validateSingleNumber(int number) {
        if (number < MINIMUM_LOTTO_NUMBER.getValue() || number > MAXIMUM_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(NOT_LOTTO_NUMBER.getMessage());
        }
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Rank evaluateRank(Lotto winningLotto, int bonusNumber) {
        Set<Integer> userNumbers = new HashSet<>(numbers);

        int count = (int) winningLotto.numbers.stream()
                .filter(userNumbers::contains)
                .count();
        boolean bonus = userNumbers.contains(bonusNumber);

        return Rank.from(count, bonus);
    }

    public boolean hasNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}

package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public Rank evaluateRank(Lotto winningLotto, int bonusNumber) {
        Set<Integer> userNumbers = new HashSet<>(numbers);

        int count = (int) winningLotto.numbers.stream()
                .filter(userNumbers::contains)
                .count();
        boolean bonus = userNumbers.contains(bonusNumber);

        return Rank.from(count, bonus);
    }
}

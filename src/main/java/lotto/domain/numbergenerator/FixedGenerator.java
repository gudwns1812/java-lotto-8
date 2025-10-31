package lotto.domain.numbergenerator;

import java.util.List;

public class FixedGenerator implements NumberGenerator {
    private final List<Integer> numbers;

    public FixedGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generateNumbers() {
        return List.copyOf(numbers);
    }
}

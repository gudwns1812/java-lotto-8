package lotto.Factory;

import lotto.controller.LottoController;
import lotto.domain.LottoSeller;
import lotto.domain.numbergenerator.NumberGenerator;
import lotto.domain.numbergenerator.RandomGenerator;
import lotto.view.printer.ConsolePrinter;
import lotto.view.reader.ConsoleReader;

public class LottoFactory {
    private LottoFactory() {
    }

    public static NumberGenerator generator() {
        return new RandomGenerator();
    }

    public static LottoSeller seller() {
        return new LottoSeller(generator());
    }

    public static LottoController controller() {
        return new LottoController(new ConsoleReader(), new ConsolePrinter(), seller());
    }
}

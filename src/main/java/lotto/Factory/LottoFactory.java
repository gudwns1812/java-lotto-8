package lotto.Factory;

import lotto.controller.LottoController;
import lotto.view.printer.ConsolePrinter;
import lotto.view.reader.ConsoleReader;

public class LottoFactory {
    private LottoFactory() {
    }

    public static LottoController controller() {
        return new LottoController(new ConsoleReader(), new ConsolePrinter());
    }
}

package lotto;

import lotto.Factory.LottoFactory;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController controller = LottoFactory.controller();
        controller.run();
    }
}

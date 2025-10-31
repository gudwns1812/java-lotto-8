package lotto;

import lotto.Factory.ApplicationFactory;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController controller = ApplicationFactory.controller();
        controller.run();
    }
}

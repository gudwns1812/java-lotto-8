package lotto;

import lotto.controller.LottoController;
import lotto.factory.ApplicationFactory;

public class Application {
    public static void main(String[] args) {
        LottoController controller = ApplicationFactory.controller();
        controller.run();
    }
}

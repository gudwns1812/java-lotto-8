package lotto.view.reader;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements Reader {
    @Override
    public String readUserFee() {
        return Console.readLine();
    }

    @Override
    public String readWinningMainNumbers() {
        return Console.readLine();
    }

    @Override
    public String readWinningBonusNumber() {
        return Console.readLine();
    }
}

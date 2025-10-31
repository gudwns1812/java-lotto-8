package lotto.view.printer;

public enum PrintMessage {
    USER_FEE_MESSAGE("구입금액을 입력해 주세요."),
    USER_PURCHASE_COUNT("개를 구매했습니다."),
    MAIN_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    BONUS_WINNING_NUMBER("\n보너스 번호를 입력해 주세요."),
    LOTTO_STATICS("\n당첨 통계"),
    HORIZON("---"),
    FORMAT_PROFIT_RATE("총 수익률은 %.2f%%입니다.");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

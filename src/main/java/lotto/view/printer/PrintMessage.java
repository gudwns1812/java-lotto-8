package lotto.view.printer;

public enum PrintMessage {
    USER_FEE_MESSAGE("구입금액을 입력해 주세요."),
    USER_PURCHASE_COUNT("개를 구매했습니다.");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

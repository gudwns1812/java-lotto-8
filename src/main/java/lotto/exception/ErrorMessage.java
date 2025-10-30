package lotto.exception;

public enum ErrorMessage {
    NOT_NUMBER("입력 값이 숫자가 아닙니다."),
    NOT_MULTIPLE_OF_1000("구입 금액이 1000의 배수가 아닙니다."),
    NOT_VALID_NUMBER("구입 금액이 0보다 작습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}

package lotto.exception;

public enum ErrorMessage {
    NOT_NUMBER("입력 값이 숫자가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    @Override
    public String toString() {
        return message;
    }
}

package lotto.util;

import static lotto.exception.ErrorMessage.NOT_NUMBER;

public final class NumberConverter {
    private NumberConverter() {
    }

    public static int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }
}

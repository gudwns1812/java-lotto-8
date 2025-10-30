package lotto.Factory;

import static lotto.exception.ErrorMessage.NOT_VALID_NUMBER;
import static lotto.util.NumberConverter.parseInt;

import lotto.domain.Customer;

public class CustomerFactory {
    private CustomerFactory() {
    }

    public static Customer createCustomerWith(String fee) {
        int numberFee = parseInt(fee);
        validateValidNumber(numberFee);
        return Customer.with(numberFee);
    }

    private static void validateValidNumber(int numberFee) {
        if (numberFee <= 0) {
            throw new IllegalArgumentException(NOT_VALID_NUMBER.getMessage());
        }
    }
}

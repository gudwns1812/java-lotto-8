package lotto.Factory;

import static lotto.exception.ErrorMessage.NOT_NUMBER;

import lotto.domain.Customer;

public class CustomerFactory {
    private CustomerFactory() {
    }

    public static Customer createCustomerWith(String fee) {
        int numberFee = parseInt(fee);
        return Customer.with(numberFee);
    }

    private static int parseInt(String fee) {
        try {
            return Integer.parseInt(fee);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }
}

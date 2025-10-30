package lotto.view.printer;

import static lotto.view.printer.PrintMessage.USER_FEE_MESSAGE;
import static lotto.view.printer.PrintMessage.USER_PURCHASE_COUNT;

import java.util.List;
import java.util.stream.Collectors;

public class ConsolePrinter implements Printer {
    @Override
    public void printEnterUserFee() {
        System.out.println(USER_FEE_MESSAGE);
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        System.out.println("\n" + lottoNumbers.size() + USER_PURCHASE_COUNT);

        System.out.println(lottoNumberString(lottoNumbers));
    }

    private String lottoNumberString(List<List<Integer>> lottoNumbers) {
        return lottoNumbers.stream()
                .map(numbers -> this.eachNumberString(numbers))
                .collect(Collectors.joining("\n"));
    }

    private String eachNumberString(List<Integer> numbers) {
        String numberString = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        return "[" + numberString + "]";
    }
}

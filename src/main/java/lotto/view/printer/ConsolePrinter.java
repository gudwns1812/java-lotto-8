package lotto.view.printer;

import static lotto.view.printer.PrintMessage.BONUS_WINNING_NUMBER;
import static lotto.view.printer.PrintMessage.FORMAT_PROFIT_RATE;
import static lotto.view.printer.PrintMessage.HORIZON;
import static lotto.view.printer.PrintMessage.LOTTO_STATICS;
import static lotto.view.printer.PrintMessage.MAIN_WINNING_NUMBER;
import static lotto.view.printer.PrintMessage.USER_FEE_MESSAGE;
import static lotto.view.printer.PrintMessage.USER_PURCHASE_COUNT;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Rank;

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

    @Override
    public void printEnterWinningNumber() {
        System.out.println(MAIN_WINNING_NUMBER);
    }

    @Override
    public void printEnterBonusNumber() {
        System.out.println(BONUS_WINNING_NUMBER);
    }

    private String lottoNumberString(List<List<Integer>> lottoNumbers) {
        return lottoNumbers.stream()
                .map(this::eachNumberString)
                .collect(Collectors.joining("\n"));
    }

    private String eachNumberString(List<Integer> numbers) {
        String numberString = numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        return "[" + numberString + "]";
    }

    @Override
    public void printFinalResult(Map<Rank, Long> rankStatistics, double profitRate) {
        System.out.println(LOTTO_STATICS);
        System.out.println(HORIZON);

        Arrays.stream(Rank.values())
                .sorted(Comparator.comparing(rank -> rank.getPrize().getValue()))
                .forEach(rank -> printEachRankStatistic(rankStatistics, rank));

        System.out.printf(FORMAT_PROFIT_RATE.toString(), profitRate);
    }

    private void printEachRankStatistic(Map<Rank, Long> rankStatics, Rank rank) {
        if (rank.equals(Rank.NONE_PLACE)) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(rank.getCorrectCount())
                .append("개 일치");

        if (rank.hasBonus()) {
            sb.append(", 보너스 볼 일치");
        }

        sb.append(" (")
                .append(makeThreeDigitComma(rank))
                .append("원) - ")
                .append(rankStatics.getOrDefault(rank, 0L))
                .append("개");

        System.out.println(sb);
    }

    private String makeThreeDigitComma(Rank rank) {
        long value = rank.getPrize().getValue();
        return new DecimalFormat("#,###").format(value);
    }
}

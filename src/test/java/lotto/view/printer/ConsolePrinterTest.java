package lotto.view.printer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsolePrinterTest {

    private final Printer printer = new ConsolePrinter();

    private ByteArrayOutputStream captor;

    @BeforeEach
    void setUp() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @Test
    void 유저가_산_로또를_오름차순으로_출력한다() {
        //given
        List<List<Integer>> numbers = List.of(List.of(8, 1, 40, 30, 22, 35));
        String sortedNumbers = "[1, 8, 22, 30, 35, 40]";
        //when
        printer.printLottoNumbers(numbers);
        //then
        Assertions.assertThat(captor.toString())
                .contains(sortedNumbers);
    }
}

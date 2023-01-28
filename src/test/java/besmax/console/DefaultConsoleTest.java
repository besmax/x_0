package besmax.console;

import org.junit.jupiter.api.Test;

import java.io.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultConsoleTest {
    public Console consoleTest = new DefaultConsole();

    @Test
    void consolePrints() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        consoleTest.print("asd123");

        assertEquals(out.toString(), ("asd123" + System.lineSeparator()));
    }

    @Test
    void consoleReadTextReturnCorrectString() {
        InputStream input = new ByteArrayInputStream("7".getBytes());
        System.setIn(input);
        String actual = consoleTest.readText();

        assertEquals("7", actual);
        System.setIn(System.in);
    }

    @Test
    void consolePrintFromFileCorrectProperties() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        consoleTest.printFromFile("input_cell");

        assertEquals(out.toString(), ("Введите номер ячейки для хода" + System.lineSeparator()));
    }

    @Test
    void consolePrintFromFileWithIncorrectKeyProperty() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        consoleTest.printFromFile("thxfgh");

        assertEquals(out.toString(), ("Ошибка печати из файла, в файле нет такого ключа" + System.lineSeparator()));
    }

}

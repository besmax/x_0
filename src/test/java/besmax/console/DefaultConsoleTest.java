package besmax.console;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;

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

}

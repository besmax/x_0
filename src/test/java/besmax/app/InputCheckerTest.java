package besmax.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import besmax.console.Console;
import besmax.console.DefaultConsole;


public class InputCheckerTest {

    private Console consoleForTest = mock(DefaultConsole.class);
    private InputChecker inputChecker = new InputChecker(consoleForTest);

    @Test
    void checkInputReturnsCorrectNumber() {
        Mockito.when(consoleForTest.readNumber()).thenReturn(5);

        assertEquals(5, inputChecker.checkInput(1));
    }

    @Test
    void checkInputReturnsCorrectChar() {
        Mockito.when(consoleForTest.readText()).thenReturn("0");

        assertEquals('0', inputChecker.checkInput('#'));
    }

}

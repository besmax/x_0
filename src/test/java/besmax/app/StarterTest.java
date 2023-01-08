package besmax.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import besmax.console.Console;
import besmax.console.DefaultConsole;


public class StarterTest {

    private Console consoleForTest = mock(DefaultConsole.class);
    private Playground playgroundForTest = mock(Playground.class);
    private InputChecker inputCheckerForTest = mock(InputChecker.class);

    private Starter starterForTest = new Starter(consoleForTest, playgroundForTest, inputCheckerForTest);

    @Test
    void getFromUserSymbolReturnsCorrectChar() {
        doNothing().when(consoleForTest).printFromFile(anyString());
        Mockito.when(inputCheckerForTest.checkInput('#')).thenReturn('x');

        assertEquals('x', starterForTest.getFromUserSymbol());
    }

    @Test
    void getSizeOfFieldFromUserReturnsCorrectNumber() {
        doNothing().when(consoleForTest).printFromFile(anyString());
        Mockito.when(inputCheckerForTest.checkInput(1)).thenReturn(9);

        assertEquals(9, starterForTest.getSizeOfFieldFromUser());
    }
}

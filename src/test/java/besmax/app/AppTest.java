package besmax.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import besmax.console.Console;
import besmax.console.DefaultConsole;

import java.util.Random;

public class AppTest {

    private Console consoleForTest = mock(DefaultConsole.class);
    private Playground playgroundForTest = mock(Playground.class);
    private App appForTest = new App(consoleForTest, playgroundForTest);



    @Test
    void checkInputNumberGetsNumberFromConsole() {
        Mockito.when(consoleForTest.readNumber()).thenReturn(5);
        appForTest.checkInputNumber();
        assertEquals(5, appForTest.checkInputNumber());
    }

    @Test
    void makeComputerMovePrints() {
        doNothing().when(consoleForTest).printFromFile(anyString());
        Mockito.when(playgroundForTest.occupyPositionOnTheField(anyInt(), anyChar())).thenReturn(true);
        doNothing().when(consoleForTest).print(anyString());
        Mockito.when(playgroundForTest.showCurrentPlayground()).thenReturn("xxx");
        Mockito.when(playgroundForTest.getSize()).thenReturn(3);

        appForTest.makeComputerMove();

        verify(consoleForTest, times(1)).printFromFile("output_my_turn");
    }

}

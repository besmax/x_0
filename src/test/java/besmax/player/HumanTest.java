package besmax.player;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import besmax.app.Playground;
import besmax.console.Console;
import besmax.console.DefaultConsole;

public class HumanTest {

    private Console consoleForTest = mock(DefaultConsole.class);
    private Playground playgroundForTest = mock(Playground.class);

    private Player humanForTest = new Human('0', consoleForTest, playgroundForTest);

    @Test
    void makeMoveReturnsTrueWhenPlaygroundAcceptsMove() {
        Mockito.when(playgroundForTest.occupyPositionOnTheField(3, humanForTest.getSymbol())).thenReturn(true);
        doNothing().when(consoleForTest).printFromFile(anyString());

        assertTrue(humanForTest.makeMove(3));
    }

    @Test
    void makeMoveReturnsFalseWhenPlaygroundNotAcceptsMove() {
        Mockito.when(playgroundForTest.occupyPositionOnTheField(3, humanForTest.getSymbol())).thenReturn(false);
        doNothing().when(consoleForTest).printFromFile(anyString());

        assertFalse(humanForTest.makeMove(3));
    }
}

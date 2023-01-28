package besmax.player;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import besmax.app.Playground;
import besmax.console.Console;
import besmax.console.DefaultConsole;

public class ComputerTest {
    private Console consoleForTest = mock(DefaultConsole.class);
    private Playground playgroundForTest = mock(Playground.class);

    private Player computerForTest = new Computer('0', consoleForTest, playgroundForTest);

    @Test
    void makeMoveReturnsTrueAfterMove() {
        doNothing().when(consoleForTest).printFromFile(anyString());
        List<Integer> availablePositions = new ArrayList<>();
        availablePositions.add(4);
        availablePositions.add(5);
        Mockito.when(playgroundForTest.findPositionsWithSymbol(anyChar())).thenReturn(availablePositions);
        Mockito.when(playgroundForTest.occupyPositionOnTheField(anyInt(), anyChar())).thenReturn(true);
        Mockito.when(playgroundForTest.showCurrentPlayground()).thenReturn("ararara");
        doNothing().when(consoleForTest).print(anyString());

        assertTrue(computerForTest.makeMove(1));
    }
}

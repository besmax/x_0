package besmax.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import besmax.console.Console;
import besmax.console.DefaultConsole;
import besmax.player.Computer;
import besmax.player.Human;
import besmax.player.Player;

public class GameTest {

    private Console consoleForTest = mock(DefaultConsole.class);
    private Playground playgroundForTest = mock(Playground.class);
    private Player computerForTest = mock(Computer.class);
    private Player humanForTest = mock(Human.class);
    private InputChecker inputCheckerForTest = mock(InputChecker.class);

    private Game gameForTest = new Game(computerForTest, humanForTest, playgroundForTest, consoleForTest, inputCheckerForTest);

    @Test
    void getPositionNumberFromUserReturnsCorrectNumber() {
        Mockito.when(playgroundForTest.getSize()).thenReturn(5);
        doNothing().when(consoleForTest).printFromFile(anyString());
        Mockito.when(inputCheckerForTest.checkInput(1)).thenReturn(5);

        assertEquals(5, gameForTest.getPositionNumberFromUser());
    }

}

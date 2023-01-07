package besmax.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import besmax.console.Console;
import besmax.console.DefaultConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<Integer> listOfPositions = new ArrayList<>();
        listOfPositions.add(2);
        doNothing().when(consoleForTest).printFromFile(anyString());
        Mockito.when(playgroundForTest.findPositionsWithSymbol(anyChar())).thenReturn(listOfPositions);
        Mockito.when(playgroundForTest.occupyPositionOnTheField(anyInt(), anyChar())).thenReturn(true);
        doNothing().when(consoleForTest).print(anyString());
        Mockito.when(playgroundForTest.showCurrentPlayground()).thenReturn("xxx");
        Mockito.when(playgroundForTest.getSize()).thenReturn(3);

        appForTest.makeComputerMove();

        verify(consoleForTest, times(1)).printFromFile("output_my_turn");
    }

    @Test
    void makeUserMoveTakesNumber() {
        Mockito.when(playgroundForTest.occupyPositionOnTheField(3, 'X')).thenReturn(true);
        doNothing().when(consoleForTest).printFromFile(anyString());

        assertTrue(appForTest.makeUserMove(3));
        verify(consoleForTest, times(1)).printFromFile("output_move_ok");
    }

    @Test
    void makeUserMoveDoesNotTakeNumber() {
        Mockito.when(playgroundForTest.occupyPositionOnTheField(3, 'X')).thenReturn(false);
        doNothing().when(consoleForTest).printFromFile(anyString());

        assertFalse(appForTest.makeUserMove(3));
        verify(consoleForTest, times(1)).printFromFile("input_wrong_cell");
    }

    @Test
    void prepareFieldCallsMethods() {
        doNothing().when(playgroundForTest).setSize(anyInt());
        doNothing().when(playgroundForTest).prepareFieldForGame();
        doNothing().when(consoleForTest).print(anyString());
        Mockito.when(playgroundForTest.showCurrentPlayground()).thenReturn("xxx");

        appForTest.prepareField(3);

        verify(playgroundForTest, times(1)).setSize(anyInt());
        verify(playgroundForTest, times(1)).prepareFieldForGame();
        verify(consoleForTest, times(1)).print(anyString());

    }

    @Test
    void setSizeOfFieldDoesNotTakeIncorrectNumber() {
        doNothing().when(consoleForTest).printFromFile(anyString());
        Mockito.when(consoleForTest.readNumber()).thenReturn(2).thenReturn(5);

        appForTest.setSizeOfField();

        verify(consoleForTest, times(2)).printFromFile("input_field");
    }

    @Test
    void checkForWinnerReturnsTrueWhenWinner() {
        doNothing().when(consoleForTest).print(anyString());
        Mockito.when(playgroundForTest.showCurrentPlayground()).thenReturn("true");
        Mockito.when(playgroundForTest.doWeHaveWinner(anyChar())).thenReturn(true);

        boolean actual = appForTest.checkForWinner('0');

        assertEquals(true, actual);
        verify(consoleForTest, times(2)).print(anyString());
        verify(playgroundForTest, times(1)).showCurrentPlayground();
        verify(playgroundForTest, times(1)).doWeHaveWinner(anyChar());
    }

    @Test
    void checkForWinnerReturnsTrueWhenNoWinner() {
        Mockito.when(playgroundForTest.doWeHaveWinner(anyChar())).thenReturn(false);

        boolean actual = appForTest.checkForWinner('0');

        assertEquals(false, actual);
        verify(playgroundForTest, times(1)).doWeHaveWinner(anyChar());
    }
}

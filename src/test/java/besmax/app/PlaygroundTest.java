package besmax.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PlaygroundTest {

    Playground playground = Playground.PLAYGROUND_INSTANCE;

    @BeforeEach
    void prepareFieldForATests() {
        playground.prepareFieldForGame();
        playground.setComputerSymbol('0');
        playground.setUserSymbol('X');
    }

    @AfterAll
    static void clearFieldForATests() {
        Playground.PLAYGROUND_INSTANCE.prepareFieldForGame();
    }

    @Test
    void prepareFieldForGamePopulateFieldWithA() {
        Map<Integer, Character> actual = playground.getField();
        actual.forEach((k, v) -> {
            assertEquals('A', v);
        });
    }

    @Test
    void showCurrentPlaygroundReturnCorrectNewFiledAsAString() {
        String actual = playground.showCurrentPlayground();
        String expected = " 1  2  3 " + System.lineSeparator() +
                " 4  5  6 " + System.lineSeparator() +
                " 7  8  9 " + System.lineSeparator();
        assertEquals(expected, actual);
    }

    @Test
    void showCurrentPlaygroundReturnCorrectNotNewFiledAsAString() {
        playground.occupyPositionOnTheField(1, 'X');
        String actual = playground.showCurrentPlayground();
        String expected = " X  2  3 " + System.lineSeparator() +
                " 4  5  6 " + System.lineSeparator() +
                " 7  8  9 " + System.lineSeparator();
        assertEquals(expected, actual);
    }

    @Test
    void checkTheRowsForWinnerDefineWinner() {
        playground.occupyPositionOnTheField(1, 'X');
        playground.occupyPositionOnTheField(2, 'X');
        playground.occupyPositionOnTheField(3, 'X');

        assertTrue(playground.checkTheRowsForWinner('X'));
        System.out.println(playground.getWinnerOfTheGame());
        assertEquals("player (row)".length(), playground.getWinnerOfTheGame().length());
    }

    @Test
    void checkTheColumnsForWinnerDefineWinner() {
        playground.occupyPositionOnTheField(1, 'X');
        playground.occupyPositionOnTheField(4, 'X');
        playground.occupyPositionOnTheField(7, 'X');

        assertTrue(playground.checkTheColumnsForWinner('X'));
        assertEquals("player (column)", playground.getWinnerOfTheGame());
    }

    @Test
    void checkTheDiagonalsForWinnerDefineWinner() {
        playground.occupyPositionOnTheField(1, 'X');
        playground.occupyPositionOnTheField(5, 'X');
        playground.occupyPositionOnTheField(9, 'X');

        assertTrue(playground.checkTheDiagonalsForWinner('X'));
        assertEquals("player (diagonal)".length(), playground.getWinnerOfTheGame().length());
    }

    @Test
    void doWeHaveWinnerDefineWinner() {
        playground.occupyPositionOnTheField(1, '0');
        playground.occupyPositionOnTheField(5, '0');
        playground.occupyPositionOnTheField(9, '0');

        assertTrue(playground.doWeHaveWinner('0'));
        assertEquals("computer (diagonal)".length(), playground.getWinnerOfTheGame().length());
    }

    @Test
    void doWeHaveWinnerNotDefineWinner() {
        playground.occupyPositionOnTheField(1, '0');
        playground.occupyPositionOnTheField(5, '0');
        playground.occupyPositionOnTheField(9, 'X');

        assertFalse(playground.doWeHaveWinner('0'));
    }

    @Test
    void setSizeDoesNotTakeNumberGreaterThanNine() {
        playground.setSize(76);

        assertEquals(playground.getSize(), 9);
        playground.setSize(3);
    }

    @Test
    void findPositionsWithSymbolReturnsCorrectList() {
        playground.occupyPositionOnTheField(1, 'x');
        playground.occupyPositionOnTheField(2, 'x');
        playground.occupyPositionOnTheField(7, 'x');
        playground.occupyPositionOnTheField(3, 'x');
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(7);

        assertEquals(expected, playground.findPositionsWithSymbol('x'));
    }
}

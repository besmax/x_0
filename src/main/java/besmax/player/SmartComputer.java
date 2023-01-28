package besmax.player;

import java.util.List;
import java.util.Random;

import besmax.app.Playground;
import besmax.console.Console;

public class SmartComputer extends Player {

    public SmartComputer(char symbol, Console console, Playground playground) {
        super(symbol, console, playground);
    }

    @Override
    public boolean makeMove(int positionNumber) {
        console.printFromFile("output_my_turn");
        boolean result = false;
        while (true) {
            if (occupyPosition(findPositionNumber(playground.findPositionsWithSymbol(symbol)))) {
                result = true;
                break;
            }
            if (occupyPosition(findPositionNumber(playground.findPositionsWithSymbol(defineUserSymbol())))) {
                result = true;
                break;
            }
            if(occupyPosition(findRandomPosition())) {
                result = true;
                break;
            }
        }
        console.print(playground.showCurrentPlayground());
        return result;
    }

    public int findPositionNumber(List<Integer> positions) {
        int result = 0;
        List<Integer> availablePositions = playground.findPositionsWithSymbol('A');

        if (availablePositions.contains(5)) result = 5;
        if ((positions.contains(1) && positions.contains(2) && availablePositions.contains(3)) ||
                (positions.contains(6) && positions.contains(9) && availablePositions.contains(3)) ||
                (positions.contains(5) && positions.contains(7) && availablePositions.contains(3)))
            result = 3;
        else if ((positions.contains(2) && positions.contains(3) && availablePositions.contains(1)) ||
                (positions.contains(4) && positions.contains(7) && availablePositions.contains(1)) ||
                (positions.contains(5) && positions.contains(9) && availablePositions.contains(1)))
            result = 1;
        else if ((positions.contains(1) && positions.contains(3) && availablePositions.contains(2)) ||
                (positions.contains(5) && positions.contains(8) && availablePositions.contains(2)))
            result = 2;
        else if ((positions.contains(1) && positions.contains(7) && availablePositions.contains(4)) ||
                (positions.contains(5) && positions.contains(6) && availablePositions.contains(4)))
            result = 4;
        else if ((positions.contains(4) && positions.contains(5) && availablePositions.contains(6)) ||
                (positions.contains(3) && positions.contains(9) && availablePositions.contains(6)))
            result = 6;
        else if ((positions.contains(1) && positions.contains(4) && availablePositions.contains(7)) ||
                (positions.contains(3) && positions.contains(5) && availablePositions.contains(7)) ||
                (positions.contains(8) && positions.contains(9) && availablePositions.contains(7)))
            result = 7;
        else if ((positions.contains(7) && positions.contains(9) && availablePositions.contains(8)) ||
                (positions.contains(2) && positions.contains(5) && availablePositions.contains(8)))
            result = 8;
        else if ((positions.contains(1) && positions.contains(5) && availablePositions.contains(9)) ||
                (positions.contains(3) && positions.contains(6) && availablePositions.contains(9)) ||
                (positions.contains(7) && positions.contains(8) && availablePositions.contains(9)))
            result = 9;

        return result;
    }

    public int findRandomPosition() {
        List<Integer> availablePositions = playground.findPositionsWithSymbol('A');
        return availablePositions.get(new Random().nextInt(availablePositions.size()));
    }

    public boolean occupyPosition(int positionNumber) {
        boolean result = false;
        if (playground.occupyPositionOnTheField(positionNumber, symbol)) result = true;
        return result;
    }

    public char defineUserSymbol() {
        if (symbol == '0') return 'X';
        else return '0';
    }

}

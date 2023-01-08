package besmax.player;

import besmax.app.Playground;
import besmax.console.Console;

public class Human extends Player {

    public Human(char symbol, Console console, Playground playground) {
        super(symbol, console, playground);
    }


    @Override
    public boolean makeMove(int positionNumber) {
        boolean result = false;
        if (playground.occupyPositionOnTheField(positionNumber, symbol)) {
            result = true;
            console.printFromFile("output_move_ok");
        }
        else {
            console.printFromFile("input_wrong_cell");
        }
        return result;
    }
}

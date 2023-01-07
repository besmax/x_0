package besmax.player;

import besmax.app.Playground;
import besmax.console.Console;

public class Human extends Player {

    private Playground playground = Playground.PLAYGROUND_INSTANCE;

    public Human(char symbol, Console console) {
        super(symbol, console);
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

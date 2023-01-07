package besmax.player;

import java.util.List;
import java.util.Random;

import besmax.app.Playground;
import besmax.console.Console;

public class Computer extends Player {

    private Playground playground = Playground.PLAYGROUND_INSTANCE;

    public Computer(char symbol, Console console) {
        super(symbol, console);
    }

    @Override
    public boolean makeMove(int positionNumber) {
        console.printFromFile("output_my_turn");
        List<Integer> availablePositions = playground.findPositionsWithSymbol('A');
        while (!playground.occupyPositionOnTheField(availablePositions.get(new Random().nextInt(availablePositions.size())), symbol));
        console.print(playground.showCurrentPlayground());
        return true;
    }


}

package besmax.player;

import besmax.app.Playground;
import besmax.console.Console;

public abstract class Player {

    protected char symbol;
    protected Console console;

    public Player(char symbol, Console console) {
        this.symbol = symbol;
        this.console = console;
        Playground playground = Playground.PLAYGROUND_INSTANCE;
    }

    public abstract boolean makeMove(int positionNumber);

    public char getSymbol() {
        return symbol;
    }
}

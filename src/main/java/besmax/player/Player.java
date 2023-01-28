package besmax.player;

import besmax.app.Playground;
import besmax.console.Console;

public abstract class Player {

    protected char symbol;
    protected Console console;
    protected Playground playground;

    public Player(char symbol, Console console, Playground playground) {
        this.symbol = symbol;
        this.console = console;
        this.playground =  playground;
    }

    public abstract boolean makeMove(int positionNumber);

    public char getSymbol() {
        return symbol;
    }
}

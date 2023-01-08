package besmax.app;

import besmax.console.Console;
import besmax.player.Computer;
import besmax.player.Human;
import besmax.player.Player;

public class Starter {

    private Console console;
    private char userSymbol;
    private char computerSymbol;
    private Playground playground;
    private InputChecker inputChecker;

    public Starter(Console console, Playground playground, InputChecker inputChecker) {
        this.console = console;
        this.playground = playground;
        this.inputChecker = inputChecker;
    }

    public void run() {
        console.printFromFile("output_rules");
        playground.setSize(getSizeOfFieldFromUser());
        playground.prepareFieldForGame();
        userSymbol = getFromUserSymbol();
        playground.setUserSymbol(userSymbol);
        Player human = new Human(userSymbol, console, playground);
        if (userSymbol == '0') computerSymbol = 'X';
        else computerSymbol = '0';
        playground.setComputerSymbol(computerSymbol);
        Player computer = new Computer(computerSymbol, console, playground);
        Game game = new Game(computer, human, playground, console, inputChecker);
        game.play();
    }

    public char getFromUserSymbol() {
        char symbol = ' ';
        while (symbol != 'X' && symbol != 'x' && symbol != '0') {
            console.printFromFile("input_symbol");
            symbol = inputChecker.checkInput('#');
        }
        return symbol;
    }

    public int getSizeOfFieldFromUser() {
        int inputSize = 0;
        while (inputSize < 3) {
            console.printFromFile("input_field");
            inputSize = inputChecker.checkInput(1);
        }
        return inputSize;
    }


}

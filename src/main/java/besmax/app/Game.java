package besmax.app;

import besmax.console.Console;
import besmax.player.Player;

public class Game {

    private Player computer;
    private Player human;
    private Playground playground;
    private Console console;
    private InputChecker inputChecker;
    private boolean playing;

    public Game(Player computer, Player human, Playground playground, Console console, InputChecker inputChecker) {
        this.computer = computer;
        this.human = human;
        this.playground = playground;
        this.console = console;
        this.inputChecker = inputChecker;
        playing = false;
    }

    public void play() {
        console.print(playground.showCurrentPlayground());
        while (!playing) {
            if (human.getSymbol() == '0') {
                computer.makeMove(1);
                playing = playground.doWeHaveWinner(computer.getSymbol());
                human.makeMove(getPositionNumberFromUser());
                console.print(playground.showCurrentPlayground());
                playing = playground.doWeHaveWinner(human.getSymbol());
            }
            else {
                human.makeMove(getPositionNumberFromUser());
                console.print(playground.showCurrentPlayground());
                playing = playground.doWeHaveWinner(human.getSymbol());
                computer.makeMove(1);
                playing = playground.doWeHaveWinner(computer.getSymbol());
            }
        }
        console.printFromFile("output_winner");
        console.print(playground.getWinnerOfTheGame());

    }

    public int getPositionNumberFromUser() {
        int inputPosition = 0;
        while (inputPosition < 1 || inputPosition > (playground.getSize() * playground.getSize())) {
            console.printFromFile("input_cell");
            inputPosition = inputChecker.checkInput(1);
        }
        return inputPosition;
    }


}


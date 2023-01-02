package besmax.app;

import besmax.console.Console;
import besmax.console.DefaultConsole;

import java.util.InputMismatchException;
import java.util.Random;

public class App {

    private char userSymbol = 'X';
    private char computerSymbol = '0';

    private Console console = new DefaultConsole();
    Playground playground = Playground.PLAYGROUND_INSTANCE;

    public void run() {
        console.printFromFile("output_rules");
        prepareField(setSizeOfField());
        for (int i = 1; i <= playground.getSize()*playground.getSize() / 2 + 1; i++) {
            int cellNumberForMove = 0;
            console.printFromFile("input_cell");
            while (true) {
                cellNumberForMove = checkInputNumber();
                if (cellNumberForMove != 0) break;
                console.printFromFile("input_wrong_number");
            }


            makeUserMove(cellNumberForMove); //тогда нужно выбрать другую ячейку




            if (playground.doWeHaveWinner(userSymbol)) {
                console.print("В этой игре победил: " + playground.getWinnerOfTheGame());
                console.print(playground.showCurrentPlayground());
                break;
            }
            console.print(playground.showCurrentPlayground());
            makeComputerMove();
            if (playground.doWeHaveWinner(computerSymbol)) {
                console.print("В этой игре победил: " + playground.getWinnerOfTheGame());
                console.print(playground.showCurrentPlayground());
                break;
            }
        }
    }

    public int setSizeOfField() {
        int inputSize = 0;
        while (inputSize < 3) {
            console.printFromFile("input_field");
            inputSize = checkInputNumber();
        }
        return inputSize;
    }

    public void prepareField(int fieldSize) {
        playground.setSize(fieldSize);
        playground.prepareFieldForGame();
        console.print(playground.showCurrentPlayground());
    }

    public void makeUserMove(int positionNumber) {
        if (playground.occupyPositionOnTheField(positionNumber, userSymbol)) {
            console.printFromFile("output_move_ok");
        }
        else {
            console.printFromFile("input_wrong_cell");
        }
    }

    public void makeComputerMove() {
        console.printFromFile("output_my_turn");
        while (!playground.occupyPositionOnTheField(new Random().nextInt(9) + 1, computerSymbol));
        console.print(playground.showCurrentPlayground());
    }

    public int checkInputNumber() {
        int result = 0;
        while (true) {
            try {
                result = console.readNumber();
                break;
            } catch (InputMismatchException e) {
                console.printFromFile("input_wrong_number");
            }
        }
        return result;
    }

}

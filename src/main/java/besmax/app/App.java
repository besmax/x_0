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
        prepareField(setSizeOfField());
        for (int i = 1; i <= playground.getSize()*playground.getSize() / 2; i++) {
            console.print("Введите номер ячейки для хода");
            makeUserMove(console.readNumber());
            if (playground.doWeHaveWinner(userSymbol)) {
                console.print("В этой игре победил: " + playground.getWinnerOfTheGame());
                console.print(playground.showCurrentPlayground());
                break;
            }
            console.print(playground.showCurrentPlayground());
            makeComputerMove();
            if (playground.doWeHaveWinner(userSymbol)) {
                console.print("В этой игре победил: " + playground.getWinnerOfTheGame());
                console.print(playground.showCurrentPlayground());
                break;
            }
        }
    }

    public int setSizeOfField() {
        console.print("Введите желаемый размер поля, но не менее 3. Например, 3 - для создания поля 3х3");
        int inputSize = 0;
        while (true) {
            try {
                inputSize = console.readNumber();
                break;

            } catch (InputMismatchException e) {
                console.print("Неккоректно введено число, попробуйте ещё раз");
            }
        }
        if (inputSize < 3) setSizeOfField();
        return inputSize;
    }

    public void prepareField(int fieldSize) {
        playground.setSize(fieldSize);
        playground.prepareFieldForGame();
        console.print(playground.showCurrentPlayground());
    }

    public void makeUserMove(int positionNumber) {
        if (playground.occupyPositionOnTheField(positionNumber, userSymbol)) {
            console.print("Ваш ход засчитан");
        }
        else {
            console.print("Смотри куда ставишь, клетка занята!");
        }
    }

    public void makeComputerMove() {
        console.print("Мой ход");
        while (!playground.occupyPositionOnTheField(new Random().nextInt(9) + 1, computerSymbol));
        console.print(playground.showCurrentPlayground());
    }

}

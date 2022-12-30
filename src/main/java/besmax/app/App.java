package besmax.app;

import besmax.console.Console;
import besmax.console.DefaultConsole;

public class App {

    private char userSymbol = 'X';

    private Console console = new DefaultConsole();
    Playground playground = Playground.PLAYGROUND_INSTANCE;

    public void run() {
        console.print("Введите желаемый размер поля. Например, 3 - для создания поля 3х3");
        playground.setSize(console.readNumber());
        playground.prepareFieldForGame();
        console.print(playground.showCurrentPlayground());

        for (int i = 1; i <= playground.getSize()*playground.getSize() / 2; i++) {
            console.print("Введите номер ячейки для хода");
            makeUserMove(console.readNumber());
            if (playground.doWeHaveWinner(userSymbol)) {
                console.print("В этой игре победил: " + playground.getWinnerOfTheGame());
                console.print(playground.showCurrentPlayground());
                break;
            }
            console.print(playground.showCurrentPlayground());

        }
    }

    public void makeUserMove(int positionNumber) {
        if (playground.occupyPositionOnTheField(positionNumber, userSymbol)) {
            console.print("Ваш ход засчитан");
        }
        else {
            console.print("Смотри куда ставишь, клетка занята!");
        }
    }

}

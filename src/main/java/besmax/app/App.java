package besmax.app;

import besmax.console.Console;
import besmax.console.DefaultConsole;

public class App {

    private char userSymbol;

    private Console console = new DefaultConsole();
    Playground playground = Playground.PLAYGROUND_INSTANCE;

    public void run() {
        console.print("Введите желаемый размер поля. Например, 3 - для создания поля 3х3");
        playground.setSize(console.readNumber());
        playground.prepareFieldForGame();
        console.print(playground.showCurrentPlayground());
    }

    public void makeMove(int positionNumber) {
        if (playground.occupyPositionOnTheField(positionNumber, userSymbol)) {
            console.print("Ваш ход засчитан");
        }
        else {
            console.print("Смотри куда ставишь, клетка занята!");
        }
    }

}

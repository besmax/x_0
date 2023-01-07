package besmax.app;

import static org.mockito.Mockito.mock;

import besmax.console.Console;
import besmax.console.DefaultConsole;
import besmax.player.Computer;
import besmax.player.Human;
import besmax.player.Player;

public class GameTest {

//    private Player computer;
//    private Player human;
//    private Playground playground;
//    private Console console;
//    private InputChecker inputChecker;
//    private boolean playing;
//
//    public Game(Player computer, Player human, Playground playground, Console console, InputChecker inputChecker) {
//        this.computer = computer;
//        this.human = human;
//        this.playground = playground;
//        this.console = console;
//        this.inputChecker = inputChecker;
//        playing = false;
//    }
//


    private Console consoleForTest = mock(DefaultConsole.class);
    private Playground playgroundForTest = mock(Playground.class);
    private Player computer = mock(Computer.class);
    private Player human = mock(Human.class);
    private InputChecker inputChecker = mock(InputChecker.class);

    private Game gameForTest = new Game(consoleForTest, playgroundForTest);
}

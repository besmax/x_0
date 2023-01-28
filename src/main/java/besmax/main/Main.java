package besmax.main;

import besmax.app.InputChecker;
import besmax.app.Playground;
import besmax.app.Starter;
import besmax.console.DefaultConsole;

public class Main {
    public static void main(String[] args) {

        Starter starter = new Starter(new DefaultConsole(), Playground.PLAYGROUND_INSTANCE, new InputChecker(new DefaultConsole()));
        starter.run();
    }
}
package besmax.main;

import besmax.app.App;
import besmax.app.Playground;
import besmax.console.Console;
import besmax.console.DefaultConsole;

public class Main {
    public static void main(String[] args) {
       App app = new App(new DefaultConsole(), Playground.PLAYGROUND_INSTANCE);
        app.run();

    }
}
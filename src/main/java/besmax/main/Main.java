package besmax.main;

import besmax.app.App;
import besmax.console.Console;
import besmax.console.DefaultConsole;

public class Main {
    public static void main(String[] args) {
       App app = new App();
        app.run();

//        Console console = new DefaultConsole();
//        console.printFromFile("output_rules");
    }
}
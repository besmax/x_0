package besmax.app;

import java.util.InputMismatchException;

import besmax.console.Console;

public class InputChecker {

    private Console console;

    public InputChecker(Console console) {
        this.console = console;
    }

    public int checkInput(int number) {
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

    public char checkInput(char symbol) {
        char result = '#';
        while (true) {
            try {
                result = console.readText().trim().charAt(0);
                break;
            } catch (StringIndexOutOfBoundsException | InputMismatchException e) {
                console.printFromFile("input_wrong_symbol");
            }
        }
        return result;
    }
}

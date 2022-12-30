package besmax.console;

import java.util.Scanner;

public class DefaultConsole implements Console {
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public int readNumber() {
        return new Scanner(System.in).nextInt();
    }

    public String readText() {
        return new Scanner(System.in).nextLine();
    }
}

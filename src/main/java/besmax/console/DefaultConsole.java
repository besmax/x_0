package besmax.console;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class DefaultConsole implements Console {

    private Properties properties;

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

    @Override
    public void printFromFile(String stringPropertyName) {
        File file = new File("src/main/resources/strings.properties");

        Properties properties = new Properties();
        try {
            properties.load(new FileReader(file));
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }
        if (properties.getProperty(stringPropertyName) == null) System.out.println("Ошибка печати из файла, в файле нет такого ключа");
        else System.out.println(properties.getProperty(stringPropertyName));
    }

}

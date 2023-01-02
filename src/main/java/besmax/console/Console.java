package besmax.console;

public interface Console {
    void print(String text);
    int readNumber();
    String readText();
    void printFromFile(String stringPropertyName);
}

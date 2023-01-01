package besmax.app;

import java.util.*;

public enum Playground {
    PLAYGROUND_INSTANCE;

    private int size = 3;

    private String winnerOfTheGame;

    private Map<Integer, Character> field;

    public void prepareFieldForGame() {
        winnerOfTheGame = "No one";
        field = new HashMap<>();
        for (int i = 1; i <= size*size; i++)
        field.put(i, 'A');
    }

    public String showCurrentPlayground() {
        StringBuilder result = new StringBuilder("");
        int elementNumber = 1;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (elementNumber < 10) result.append(" ");
                if (field.get(elementNumber) == 'A') result.append(elementNumber)
                        .append(" ");
                else if (field.get(elementNumber) == '0') result.append('0')
                        .append(" ");
                else if (field.get(elementNumber) == 'x' || field.get(elementNumber) == 'X') result.append('X')
                        .append(" ");
                elementNumber++;
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

    public boolean occupyPositionOnTheField (int positionNumber, char userOrNot) {
         if (field.get(positionNumber) == 'A') {
             field.put(positionNumber, userOrNot);
             return true;
         }
         else {
             return false;
         }
    }

    public boolean checkTheRowsForWinner(char winnerSymbol) {
        boolean result = false;
        for (int i = 1; i <= field.size(); i += size) {
            if (field.get(i) == winnerSymbol && field.get(i+1) == winnerSymbol && field.get(i+2) == winnerSymbol) {
                result = true;
                if (winnerSymbol == 'x' || winnerSymbol == 'X') winnerOfTheGame = "игрок";
                if (winnerSymbol == '0' ) winnerOfTheGame = "компьютер";
            }
        }
        return result;
    }

    public boolean checkTheColumnsForWinner(char winnerSymbol) {
        boolean result = false;
        for (int i = 1; i <= size; i ++) {
            if (field.get(i) == winnerSymbol && field.get(i+size) == winnerSymbol && field.get(i+size+size) == winnerSymbol) {
                result = true;
                if (winnerSymbol == 'x' || winnerSymbol == 'X') winnerOfTheGame = "игрок";
                if (winnerSymbol == '0' ) winnerOfTheGame = "компьютер";
            }
        }
        return result;
    }

    public boolean checkTheDiagonalsForWinner(char winnerSymbol) {
        boolean result = false;
        for (int i = 1; i < 3; i++) {
            int j = 1;
            if (field.get(j) == winnerSymbol && field.get(j+size+1) == winnerSymbol && field.get(j+size+size+2) == winnerSymbol) {
                result = true;
                if (winnerSymbol == 'x' || winnerSymbol == 'X') winnerOfTheGame = "игрок";
                if (winnerSymbol == '0' ) winnerOfTheGame = "компьютер";
            }
            j+=2;
        }
        return result;
    }

    public boolean doWeHaveWinner(char winnerSymbol) {
        if (checkTheRowsForWinner(winnerSymbol)) return true;
        if (checkTheColumnsForWinner(winnerSymbol)) return true;
        if (checkTheDiagonalsForWinner(winnerSymbol)) return true;
        return false;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getWinnerOfTheGame() {
        return winnerOfTheGame;
    }
}

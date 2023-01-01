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
        int elementNumber = 1;
        for (int i = 1; i <= size; i ++) {
            Set<Character> uniqueSymbolsInRow = new HashSet<>();
           for (int j = 1; j <= size; j++){
               uniqueSymbolsInRow.add(field.get(elementNumber));
               elementNumber++;
               }
            if (uniqueSymbolsInRow.size() == 1 && !uniqueSymbolsInRow.contains('A')) {
                result = true;
                if (uniqueSymbolsInRow.contains('0')) winnerOfTheGame = "компьютер (строка)";
                if (uniqueSymbolsInRow.contains('x') || uniqueSymbolsInRow.contains('X')) winnerOfTheGame = "игрок (строка)";
           }
        }
        return result;
    }

    public boolean checkTheColumnsForWinner(char winnerSymbol) {
        boolean result = false;
        for (int i = 1; i <= size; i ++) {
            Set<Character> uniqueSymbolsInColumn = new HashSet<>();
            int elementNumber = i;
            for (int j = 1; j <= size; j++) {
                uniqueSymbolsInColumn.add(field.get(elementNumber));
                elementNumber += size;
            }
            if (uniqueSymbolsInColumn.size() == 1 && !uniqueSymbolsInColumn.contains('A')) {
                result = true;
                if (uniqueSymbolsInColumn.contains('0')) winnerOfTheGame = "компьютер (cтолбец)";
                if (uniqueSymbolsInColumn.contains('x') || uniqueSymbolsInColumn.contains('X'))
                    winnerOfTheGame = "игрок (cтолбец)";
            }
        }
        return result;
    }

    public boolean checkTheDiagonalsForWinner(char winnerSymbol) {
        boolean result = false;
        Set<Character> uniqueSymbolsInDiagonal = new HashSet<>();
        for (int i = 1; i <= field.size(); i = i + size + 1) {
            uniqueSymbolsInDiagonal.add(field.get(i));
        }
        if (uniqueSymbolsInDiagonal.size() == 1 && !uniqueSymbolsInDiagonal.contains('A')) {
            result = true;
            if (uniqueSymbolsInDiagonal.contains('0')) winnerOfTheGame = "компьютер (диагональ)";
            if (uniqueSymbolsInDiagonal.contains('x') || uniqueSymbolsInDiagonal.contains('X'))
                winnerOfTheGame = "игрок (диагональ)";
        }

        uniqueSymbolsInDiagonal.clear();

        for (int i = size; i <= field.size() - size + 1; i = i + size - 1) {
            uniqueSymbolsInDiagonal.add(field.get(i));
        }
        if (uniqueSymbolsInDiagonal.size() == 1 && !uniqueSymbolsInDiagonal.contains('A')) {
            result = true;
            if (uniqueSymbolsInDiagonal.contains('0')) winnerOfTheGame = "компьютер (диагональ)";
            if (uniqueSymbolsInDiagonal.contains('x') || uniqueSymbolsInDiagonal.contains('X'))
                winnerOfTheGame = "игрок (диагональ)";
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

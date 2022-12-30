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

    private boolean doWeHaveWinner(char winner) {
        boolean result = false;
        List<Integer> winnerPositions = new ArrayList<>();
        field.forEach((key, val) -> {
            if (val.equals(winner) || val.equals(winner)) winnerPositions.add(key);
        });

        if (winnerPositions.size() < size) result = false;
        else if ( (winnerPositions.contains(1) && winnerPositions.contains(2) && winnerPositions.contains(3)) ||
                (winnerPositions.contains(4) && winnerPositions.contains(5) && winnerPositions.contains(6)) ||
                (winnerPositions.contains(7) && winnerPositions.contains(8) && winnerPositions.contains(9)) ||
                (winnerPositions.contains(1) && winnerPositions.contains(4) && winnerPositions.contains(7)) ||
                (winnerPositions.contains(2) && winnerPositions.contains(5) && winnerPositions.contains(8)) ||
                (winnerPositions.contains(3) && winnerPositions.contains(6) && winnerPositions.contains(9)) ||
                (winnerPositions.contains(1) && winnerPositions.contains(5) && winnerPositions.contains(9)) ||
                (winnerPositions.contains(3) && winnerPositions.contains(5) && winnerPositions.contains(7)) ) {
            if (winner == 'x' && winner == 'X') winnerOfTheGame = "user";
            if (winner == '0' ) winnerOfTheGame = "AI";
            result = true;
        }
        return result;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

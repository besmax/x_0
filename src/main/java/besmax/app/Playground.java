package besmax.app;

import java.util.HashMap;
import java.util.Map;

public enum Playground {
    PLAYGROUND_INSTANCE;

    private int size = 3;

    private Map<Integer, Character> field ;

    public void populateFiled() {
        field = new HashMap<>();
        for (int i = 1; i < size*size; i++)
        field.put(i, 'A');

    }

    public void setSize(int size) {
        this.size = size;
    }
}

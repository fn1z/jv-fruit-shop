package core.basesyntax.storage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> storage = new HashMap<>();

    public void put(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    public int get(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    public void increase(String fruit, int amount) {
        storage.put(fruit, get(fruit) + amount);
    }

    public void decrease(String fruit, int amount) {
        storage.put(fruit, get(fruit) - amount);
    }

    public Map<String, Integer> getAll() {
        return Collections.unmodifiableMap(storage);
    }
}

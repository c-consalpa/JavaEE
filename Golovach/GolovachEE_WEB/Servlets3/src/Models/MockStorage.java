package Models;

import java.util.HashMap;
import java.util.Map;

public class MockStorage {
    public static Map<Integer, String> mockStorage = new HashMap<>();

    public MockStorage() {
        mockStorage.put(1, "sugar");
        mockStorage.put(2, "bread");
    }
}

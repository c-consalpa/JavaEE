package consalpa.Data;

import java.util.HashMap;
import java.util.Map;

public class MockStorage {
    private Map<Long, String> storage = new HashMap<>();
    public MockStorage() {
        storage.put(90L, "oil");
        storage.put(5L, "bread");
        storage.put(66L, "wine");
    }

    public synchronized Map<Long, String> getStorage() {
        return storage;
    }
}

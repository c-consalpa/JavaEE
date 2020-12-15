package consalpa.Data;

import java.util.HashMap;
import java.util.Map;

public class MockStorage {
    private Map<Long, String> storage = new HashMap<>();
    public MockStorage() {
        storage.put(1L, "oil");
        storage.put(2L, "bread");
        storage.put(3L, "wine");
    }



    public synchronized Map<Long, String> getStorage() {
        return storage;
    }
}

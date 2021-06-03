package xany.model.annotatedModels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sql")
public class SQLDataStorage implements DataStorage {
    // Constructor injection

    private StorageConnector connector;

    @Autowired
    public SQLDataStorage(StorageConnector connector) {
        this.connector = connector;
    }

    @Override
    public String getData() {
        return "SQL";
    }

    @Override
    public void writeData() {

    }

    @Override
    public StorageConnector getConnector() {
        return connector;
    }
}

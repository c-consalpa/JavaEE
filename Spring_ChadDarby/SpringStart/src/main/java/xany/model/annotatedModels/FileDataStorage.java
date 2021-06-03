package xany.model.annotatedModels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("fs")
public class FileDataStorage implements DataStorage {

    @Autowired
    private StorageConnector fileStorageConnector;

    @Override
    public String getData() {
        return null;
    }

    @Override
    public void writeData() {

    }

    @Override
    public StorageConnector getConnector() {
        return fileStorageConnector;
    }
}

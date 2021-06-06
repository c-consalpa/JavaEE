package xany.model.annotatedModels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dff")
public class DFFDataStorage implements DataStorage {
    private StorageConnector connector;

//    @Autowired
//    public void setConnector(StorageConnector storageConnector) {
//        System.out.println("Setter called");
//        this.connector = storageConnector;
//    }

    @Autowired
    public void customMethod(StorageConnector storageConnector) {
        System.out.println("Custom autowired method");
        this.connector = storageConnector;
    }


    @Override
    public String getData() {
        return "DFF";
    }

    @Override
    public void writeData() {

    }

    @Override
    public StorageConnector getConnector() {
        return this.connector;
    }
}

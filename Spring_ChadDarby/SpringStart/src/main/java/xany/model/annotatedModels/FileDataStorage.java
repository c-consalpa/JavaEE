package xany.model.annotatedModels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("fs")
public class FileDataStorage implements DataStorage {

    @Autowired
    private StorageConnector fileStorageConnector;

    @Override
    public String getData() {
        return "fs";
    }

    @Override
    public void writeData() {

    }

    @PostConstruct
    public void mInitMethod() {
        System.out.println("created :" + this + " | " + getConnector());
    }

    @PreDestroy
    public void mCleanupMethod() {

    }

    @Override
    public StorageConnector getConnector() {
        return this.fileStorageConnector;
    }
}

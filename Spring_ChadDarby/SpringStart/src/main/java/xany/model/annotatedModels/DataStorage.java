package xany.model.annotatedModels;

public interface DataStorage {
    public String getData();

    public void writeData();

    public StorageConnector getConnector();
}

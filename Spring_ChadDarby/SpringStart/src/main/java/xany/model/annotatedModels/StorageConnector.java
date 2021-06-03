package xany.model.annotatedModels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StorageConnector {
    @Value("${fs.connector.class}")
    private String className;

    @Override
    public String toString() {
        return "StorageConnector{" +
                "className='" + className + '\'' +
                '}';
    }
}

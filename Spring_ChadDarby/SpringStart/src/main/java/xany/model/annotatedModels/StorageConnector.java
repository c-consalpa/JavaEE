package xany.model.annotatedModels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StorageConnector {
    @Value("${connector.type}")
    private String className;

    @Override
    public String toString() {
        return "StorageConnector{ samplePayload=" + className + "}";
    }


    @PostConstruct
    public void mInitMethod() {
        System.out.println("Created StorageConnector");
    }
}

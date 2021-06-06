package xany.model.annotatedModels.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

@Component
public class ShapeProvider {


    private String shape;

    public String getShape() {
        try (InputStream is = new FileInputStream("src/main/resources/shapes.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            String[] figures = new String[properties.getProperty("shapes").split(",").length];
            figures = properties.getProperty("shapes").split(",");
            return figures[(int) (Math.random() * figures.length)];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
return "";
    }

    public ShapeProvider() {

    }
}

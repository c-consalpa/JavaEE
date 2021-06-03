package xany.model.annotatedModels.assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("src/main/resources/shapes.properties")) {
            Properties properties = new Properties();
            properties.load(is);

            properties.getProperty("shapes").split(",");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

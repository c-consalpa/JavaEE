package xany.model.annotatedModels.assignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/shapesContext.xml");
        ShapeProvider sp = (ShapeProvider) ctx.getBean("shapeProvider");
        System.out.println(sp.getShape());
        System.out.println(sp.getShape());
        System.out.println(sp.getShape());
        System.out.println(sp.getShape());
        System.out.println(sp.getShape());
    }
}

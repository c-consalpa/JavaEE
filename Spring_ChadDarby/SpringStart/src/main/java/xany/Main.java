package xany;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import xany.model.Boat;
import xany.model.Vehicle;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/appContext.xml");
        Vehicle vehicle = (Vehicle) ctx.getBean("car");
        System.out.println(vehicle);

        Vehicle vehicle1 = (Vehicle) ctx.getBean("bike");
        System.out.println(vehicle1);

        Vehicle vehicle2 = (Vehicle) ctx.getBean("boat");
        System.out.println(vehicle2);
        vehicle2.getMaxSpeed();

    }
}

package xany;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import xany.model.Boat;
import xany.model.Vehicle;

public class Main {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/appContext.xml");
        Vehicle vehicle = (Vehicle) ctx.getBean("car");
        System.out.println(vehicle);
        System.out.println();

//        Vehicle vehicle1 = (Vehicle) ctx.getBean("bike");
//        System.out.println(vehicle1);
//
//        Vehicle vehicle2 = (Vehicle) ctx.getBean("boat");
//        System.out.println(vehicle2);
//        vehicle2.getMaxSpeed();
        Vehicle v2 = (Vehicle) ctx.getBean("car");
        System.out.println(v2);


    }
}

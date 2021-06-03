package xany;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import xany.model.annotatedModels.DataStorage;

public class Main_AnnotatedConfigs {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/appContextAnnotatedConfig.xml");
//        DataStorage ds = (DataStorage) context.getBean("sql");
//        System.out.println(ds.getConnector());
//
//        DataStorage ds1 = (DataStorage) context.getBean("dff");
//        System.out.println(ds1.getConnector());

        DataStorage ds2 = (DataStorage) context.getBean("fs");
        System.out.println(ds2.getConnector());
    }
}

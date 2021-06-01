package xany;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import xany.model.annotatedModels.Ant;
import xany.model.annotatedModels.Creature;

public class Main_AnnotatedConfigs {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/appContextAnnotatedConfig.xml");
        Ant ant1 = context.getBean("ant", xany.model.annotatedModels.Ant.class);
        ant1.breathe();
    }
}

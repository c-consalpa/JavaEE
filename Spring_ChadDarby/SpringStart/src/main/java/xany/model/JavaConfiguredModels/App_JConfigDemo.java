package xany.model.JavaConfiguredModels;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App_JConfigDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SportConfig.class);

        Coach c = (Coach) ctx.getBean("soccerCoach");
        System.out.println(c);
    }
}

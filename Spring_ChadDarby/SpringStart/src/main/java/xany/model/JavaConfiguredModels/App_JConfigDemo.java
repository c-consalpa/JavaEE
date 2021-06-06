package xany.model.JavaConfiguredModels;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App_JConfigDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SportConfig.class);
//        Coach coach = (Coach) ctx.getBean("tennisCoach");
    Coach theCoach = ctx.getBean("swimCoach", SwimCoach.class);

        System.out.println(theCoach.giveTask());
    }
}

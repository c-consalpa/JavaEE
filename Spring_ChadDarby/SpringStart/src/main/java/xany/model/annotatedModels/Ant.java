package xany.model.annotatedModels;

import org.springframework.stereotype.Component;

@Component("ant")
public class Ant implements Creature {
    @Override
    public void breathe() {
        System.out.println("ants breathe hz kak");
    }
}

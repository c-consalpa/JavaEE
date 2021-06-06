package xany.model.JavaConfiguredModels;

import org.springframework.stereotype.Component;


public class TennisCoach implements Coach {


    @Override
    public String giveTask() {
        return "tennis tasks";
    }
}

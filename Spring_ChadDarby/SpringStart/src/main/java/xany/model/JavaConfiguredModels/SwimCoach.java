package xany.model.JavaConfiguredModels;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    EmployeeData data;

    @Value("${foo.team}")
    private String team;

    public SwimCoach(EmployeeData mdata) {
        this.data = mdata;
    }

    @Override
    public String giveTask() {
        return "swimming tasks by " + data.getEmail() + " " + team;
    }
}

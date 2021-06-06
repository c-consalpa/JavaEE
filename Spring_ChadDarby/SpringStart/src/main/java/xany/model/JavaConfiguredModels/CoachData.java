package xany.model.JavaConfiguredModels;

import org.springframework.beans.factory.annotation.Value;

public class CoachData implements EmployeeData {

    @Value("${foo.email}")
    public String email;


    @Override
    public String getEmail() {
//        return "mcoach@gmail.com";
        return email;
    }
}

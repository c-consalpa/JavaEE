package xany.model.JavaConfiguredModels;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:coachProps.properties")
public class SportConfig {

    @Bean
    public EmployeeData employeeData() {
        return new CoachData();
    }

    @Bean
    public Coach swimCoach() {
        return new SwimCoach(employeeData());
    }

}

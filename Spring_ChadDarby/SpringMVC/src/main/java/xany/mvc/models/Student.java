package xany.mvc.models;

import xany.mvc.validation.UniversityAllowed;

import javax.validation.constraints.*;
// Model class to demonstrate hibernate validation

public class Student {
    private String name;

    @NotEmpty(message = "can't be empty")
    @Size(min = 1, message = "minimum length = 1")
    private String pwd;

    @Pattern(regexp = ".*@.*\\..*")
    private String email;

    @NotNull
    @Min(value = 6, message = "age must be >= 6")
    private Integer age;


    @UniversityAllowed
    private String university;

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", university='" + university + '\'' +
                '}';
    }
}

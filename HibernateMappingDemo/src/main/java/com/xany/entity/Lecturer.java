package com.xany.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lecturer")
public class Lecturer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private LecturerDetails lecturerDetails;

    @OneToMany(mappedBy = "teachingLecturer",
            cascade = {CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            })
    private List<Course> courses;




    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LecturerDetails getLecturerDetails() {
        return lecturerDetails;
    }

    public void setLecturerDetails(LecturerDetails lecturerDetails) {
        this.lecturerDetails = lecturerDetails;
    }

    public Lecturer(String name) {
        this.name = name;
    }


    public Lecturer() {
    }

    public void addCourse(Course c) {
        if (courses==null){
            courses = new ArrayList<>();
        }

        courses.add(c);
        c.setTeachingLecturer(this);
    }
}

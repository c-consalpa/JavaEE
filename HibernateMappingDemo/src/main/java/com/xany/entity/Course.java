package com.xany.entity;

import javax.persistence.*;


@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "course_name")
    private String course_name;


    @ManyToOne(cascade = {CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "lecturer_id")
    private Lecturer teachingLecturer;


    public Lecturer getTeachingLecturer() {
        return teachingLecturer;
    }

    public void setTeachingLecturer(Lecturer teachingLecturer) {
        this.teachingLecturer = teachingLecturer;
    }

    public Course(String course_name) {
        this.course_name = course_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Course() {
    }
}

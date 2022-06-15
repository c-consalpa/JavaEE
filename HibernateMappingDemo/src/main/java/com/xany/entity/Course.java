package com.xany.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "course_name")
    private String course_name;


    @ManyToOne(
            cascade = {CascadeType.MERGE, // Defines only specific operation should be 'cascaded'.
            CascadeType.PERSIST,             // Updating a course will update the course in lecturer's course list
            CascadeType.DETACH,              // Still, deleting a course won't delete the lecturer entry
            CascadeType.REFRESH
    })
    @JoinColumn(name = "lecturer_id")  // this points to "lecturer_id" field in `course` table.
    private Lecturer teachingLecturer;


    @OneToMany(cascade = CascadeType.ALL) // deleting a course will delete all entries in `review` that reference to the course being deleted.
    @JoinColumn(name = "course_id") // this points to "course_id" field in `review` table
    private List<Review> reviews;


    // multiple students can be assigned to several courses
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, // Deleting a single Course won't delete linked Students
                CascadeType.PERSIST,
                CascadeType.DETACH,
                CascadeType.REFRESH
    })
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;





    public void addReview(Review r) {
        if (reviews==null) {
            reviews = new ArrayList<>();
        }
        reviews.add(r);
    }

    public void addStudent(Student student) {
        if (students==null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

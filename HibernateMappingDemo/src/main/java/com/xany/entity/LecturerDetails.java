package com.xany.entity;

import javax.persistence.*;

@Entity
@Table(name = "lecturer_details")
public class LecturerDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "lecturerDetails", cascade = CascadeType.ALL)
    Lecturer lecturer;

    public LecturerDetails(String email) {
        this.email = email;
    }

    public LecturerDetails() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
}

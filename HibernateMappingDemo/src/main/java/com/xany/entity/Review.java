package com.xany.entity;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "review_text")
    private String reviewText;

    @Column(name = "course_id")
    private String courseId;


    public Review() {

    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}




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
}

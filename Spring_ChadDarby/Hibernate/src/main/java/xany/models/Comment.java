package xany.models;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "comment_text")
    private String commentText;

    @ManyToOne(cascade = {CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "user_id")
    private User user;


    public Comment(String commentText) {
        this.commentText = commentText;

    }

    public Comment() {

    }






    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

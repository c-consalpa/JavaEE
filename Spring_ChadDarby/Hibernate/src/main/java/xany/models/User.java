package xany.models;

import javax.persistence.*;

@Entity
@Table(name= "users")
public class User {

    public User() {
    }


    // Leave IDs auto-generated. No need to pass them in constructor
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public User(String userName) {
        this.userName = userName;
    }

    @Column(name = "user_name")
    private String userName;

    // Unidirectional User->UserDetail
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private UserDetail userDetail;
















    //    get/set:


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userDetails=" + userDetail +
                '}';
    }
}

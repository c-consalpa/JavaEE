package xany.models;

import org.hibernate.annotations.CollectionId;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
public class UserDetail {

    // Leave IDs auto-generated. No need to pass them in constructor
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_role")
    private String userRole;


    // Bidirectional relationship:
    @OneToOne(mappedBy = "userDetail", cascade = CascadeType.ALL)
    private User user;

    public UserDetail(String userEmail, String userRole) {
        this.userEmail = userEmail;
        this.userRole = userRole;
    }











//    get/set:




    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}

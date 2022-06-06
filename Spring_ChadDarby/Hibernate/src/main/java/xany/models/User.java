package xany.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "users")
public class User {

    public User() {
    }

    @Id
    @Column(name = "id")
    private long id;

    public User(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    @Column
    private String userName;

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
}

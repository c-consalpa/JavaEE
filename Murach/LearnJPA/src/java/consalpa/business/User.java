/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consalpa.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public long userId;
    
    @Column(name="name")
    public String userName;
    
    @Column(name="city")
    public String cityID;

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public long getUserID() {
        return this.userId;
    }

    public void setUserID(long userID) {
        this.userId = userID;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + '}';
    }

    
}

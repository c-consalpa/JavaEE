/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consalpa.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
    
    @Id
    @GeneratedValue
    public long user_id;
    
    public String user_name;

    public long getUserID() {
        return user_id;
    }

    public void setUserID(long userID) {
        this.user_id = userID;
    }

    
}

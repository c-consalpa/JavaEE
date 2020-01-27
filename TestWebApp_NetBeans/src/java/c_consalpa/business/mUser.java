/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_consalpa.business;

/**
 *
 * @author c-consalpa
 */
public class mUser {
    private String name;
    private String email;

    public mUser() {
        this.name = "";
        this.email="some.defaultemail@cac.com";
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String nm) {
        this.name = nm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}

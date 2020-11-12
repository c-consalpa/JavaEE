package consalpa.JSFBeans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Konstantin
 */
@ManagedBean
@RequestScoped
public class mBean implements Serializable {

    public mBean() {
    }
    
    private String name = "abc";

    public String getname() {
        return name;
    }
    
    
    @PostConstruct
    public void initiateBean() {
        System.out.println("bean initialized;");
    }
}

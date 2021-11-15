package xany.mvc.models;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String firstName;
    private String lastName;
    private String country;
    private String role;
    private ArrayList<String> involvedProjects;



    private HashMap<String, String> countryValues;



    public User() {
        countryValues = new HashMap<>();
        countryValues.put("RU", "Russia");
        countryValues.put("US", "United States");
    }






    public void setFirstName(String firstName) {
//        System.out.println("called setFirstName");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public HashMap<String, String> getCountryValues() {
        return countryValues;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setInvolvedProjects(ArrayList<String> involvedProjects) {
        this.involvedProjects = involvedProjects;
    }

    public ArrayList<String> getInvolvedProjects() {
        return involvedProjects;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", role='" + role + '\'' +
                ", involvedProjects=" + involvedProjects +
                ", countryValues=" + countryValues +
                '}';
    }
}

package com.example.raphael.otime;

import java.util.Date;

/**
 * Created by raphi on 07/11/2017.
 */

public class User {
    private int id;
    private String email;
    private String firstname;
    private String lastname;
    private Date dateOfCreation;

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public User(String email, String firstname, String lastname) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfCreation = dateOfCreation;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastname(String laststname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}

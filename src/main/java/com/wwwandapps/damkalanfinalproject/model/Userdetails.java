package com.wwwandapps.damkalanfinalproject.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
 
 public class Userdetails {

    private Long id;
    private String firstName;
    private String email;
    private String city;
    private String teamname;
    private Long  nbateamid;
    public Userdetails() {}

    public Userdetails(Long id,String firstName, String email, String teamname, String city,Long  nbateamid) {
      this.id = id;
      this.firstName = firstName;
      this.email = email;
      this.teamname = teamname;
      this.city = city;
      this.nbateamid = nbateamid;
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String Teamname) {
        this.teamname = Teamname;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

     public String getCity() {
         return city;
     }

     public void setCity(String city) {
         this.city = city;
     }

     public Long getNbateamid() {
         return nbateamid;
     }

     public void setNbateamid(Long nbateamid) {
         this.nbateamid = nbateamid;
     }

  }
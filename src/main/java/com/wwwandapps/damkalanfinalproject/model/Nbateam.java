package com.wwwandapps.damkalanfinalproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


 @Entity
 public class Nbateam {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String abbreviation;
    private String city;
    private String conference;
    private String division;
    private String fullname;
    private String name;

    public Nbateam() {}

    public Nbateam( Long id, String abbreviation, String city, String conference, String division, String fullname, String name) {
        this.id = id;
	  this.abbreviation = abbreviation;
	  this.city = city;
	  this.conference = conference;
	  this.division = division;
	  this.fullname = fullname;
	  this.name = name;
    }

    public Long getId() {
      return id;
    }

    public String getAbbreviation() {
      return abbreviation;
    }
    public String getCity() {
     return city;
    }
    public String getConference() {
         return conference;
     }
    public String getDivision() {
         return division;
     }
    public String getFullname() {
         return fullname;
     }
    public String getName() {
         return name;
     }


    public void setId(Long id) {
         this.id = id;
     }

    public void setAbbreviation(String abbreviation) {
      this.abbreviation = abbreviation;
    }
    public void setCity(String city) {
     this.city = city;
    }
    public void setConference(String conference) {
         this.conference = conference;
     }
    public void setDivision(String division) {
         this.division = division;
     }
    public void setFullname(String fullname) {
         this.fullname = fullname;
     }
    public void setName(String name) {
         this.name = name;
     }


     public boolean isNew() {
         return (this.id == null);
     }

 }
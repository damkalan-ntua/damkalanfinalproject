package com.wwwandapps.damkalanfinalproject.dom;
 

 
 public class UserDetails {

    private Long id;
    private String firstName;
    private String email;
     private String city;
    private String teamname;

    public UserDetails() {}

    public UserDetails(String firstName, String email, String teamname, String city) {
      this.firstName = firstName;
      this.email = email;
      this.teamname = teamname;
        this.city = city;
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
 
  }
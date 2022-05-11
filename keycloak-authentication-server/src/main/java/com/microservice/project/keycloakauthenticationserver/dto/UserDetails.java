package com.microservice.project.keycloakauthenticationserver.dto;

public class UserDetails {

    private String username;
    private String email;
    private String lastname;
    private String realmName;

    public UserDetails() {
    }

    public UserDetails(String username, String email, String lastname, String realmName) {
        this.username = username;
        this.email = email;
        this.lastname = lastname;
        this.realmName = realmName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRealmName() {
        return realmName;
    }

    public void setRealmName(String realmName) {
        this.realmName = realmName;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", lastname='" + lastname + '\'' +
                ", realmName='" + realmName + '\'' +
                '}';
    }
}

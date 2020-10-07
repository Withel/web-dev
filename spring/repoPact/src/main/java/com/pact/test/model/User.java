package com.pact.test.model;


public class User {
    private Integer userdbID;
    private String username;
    private String password;

    public User(Integer userdbID, String username, String password) {
        this.userdbID = userdbID;
        this.username = username;
        this.password = password;
    }

    public Integer getUserdbID() {
        return userdbID;
    }

    public void setUserdbID(Integer dbID) {
        this.userdbID = dbID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   /* @Override
    public String toString() {
        return "ID:"+this.userdbID+ " username:"+this.username+ " password:"+this.password+"\n";
    }*/
}

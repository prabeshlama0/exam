package com.exam.examserver.entity;

public class JwtRequest {
    String userName;
    String password;

    public JwtRequest() {
    }

    public JwtRequest(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

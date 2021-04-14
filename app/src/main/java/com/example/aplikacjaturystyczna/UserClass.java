package com.example.aplikacjaturystyczna;

public class UserClass {
    String email;
    int pwdHashCode;

    public UserClass() {
    }

    public UserClass(String email, int pwdHashCode) {
        this.email = email;
        this.pwdHashCode = pwdHashCode;
    }

    public String getEmail() {
        return email;
    }

    public int getPwdHashCode() {
        return pwdHashCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwdHashCode(int pwdHashCode) {
        this.pwdHashCode = pwdHashCode;
    }
}


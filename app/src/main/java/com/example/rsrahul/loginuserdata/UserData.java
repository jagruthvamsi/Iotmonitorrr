package com.example.rsrahul.loginuserdata;

/**
 * Created by Jagruth Vamsi on 21-05-2018.
 */

public class UserData {

    String userId;
    String userName;
    String Age;
    String Email;
    String Password;

  public UserData(){

  }

    public UserData(String userId, String userName, String age, String email, String password) {
        this.userId = userId;
        this.userName = userName;
        this.Age = age;
        this.Email = email;
        this.Password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getAge() {
        return Age;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(String age) {
        Age = age;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

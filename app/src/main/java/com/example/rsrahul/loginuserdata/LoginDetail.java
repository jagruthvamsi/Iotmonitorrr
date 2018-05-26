package com.example.rsrahul.loginuserdata;

/**
 * Created by jagruthvamsi 22-05-2018.
 */

public class LoginDetail {

   public String time;
   public String email;
   public String id;
   public String location;

  public   LoginDetail(){

    }

    public LoginDetail(String id,String time, String email,String location) {
        this.time = time;
        this.email = email;
        this.id=id;
        this.location=location;
    }


}

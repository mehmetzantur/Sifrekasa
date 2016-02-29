package com.mehmetzantur.sifrekasa.Poco;

public class User {
    private Integer UserId;
    private String UserPass;

    public Integer getUserId(){
        return UserId;
    }

    public void setUserId(Integer UserId){
        this.UserId = UserId;
    }

    public String getUserPass(){
        return UserPass;
    }

    public void setUserPass(String pass){
        this.UserPass = pass;
    }
}

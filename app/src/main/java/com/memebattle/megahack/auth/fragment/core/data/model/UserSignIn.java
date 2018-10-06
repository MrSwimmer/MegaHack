package com.memebattle.megahack.auth.fragment.core.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UserSignIn {
    @SerializedName("email")
    @Expose
    public String mail;

    @SerializedName("password")
    @Expose
    public String password;

    public UserSignIn(){

    }
    public UserSignIn(String mail, String password){
        super();
        this.mail = mail;
        this.password = password;
    }
}

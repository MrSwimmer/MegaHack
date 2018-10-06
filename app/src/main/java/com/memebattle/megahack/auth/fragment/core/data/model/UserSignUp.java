package com.memebattle.megahack.auth.fragment.core.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserSignUp {
    @SerializedName("email")
    @Expose
    public String mail;

    @SerializedName("firstName")
    @Expose
    public String name;

    @SerializedName("password")
    @Expose
    public String password;

    @SerializedName("problems")
    @Expose
    public ArrayList<String> problems;
    public UserSignUp(){

    }
    public UserSignUp(String mail, String name, String password, ArrayList<String> problems){
        super();
        this.mail = mail;
        this.name = name;
        this.password = password;
        this.problems = problems;
    }
}

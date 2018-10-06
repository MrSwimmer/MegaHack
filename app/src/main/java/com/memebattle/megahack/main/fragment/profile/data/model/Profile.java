package com.memebattle.megahack.main.fragment.profile.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Profile {
    @SerializedName("status")
    @Expose
    public boolean status;

    @SerializedName("opsId")
    @Expose
    public String opsId;

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("problems")
    @Expose
    public ArrayList<String> problems;


    public Profile(){

    }
    public Profile(boolean status, String opsId, String email, String name, ArrayList<String> problems){
        super();
        this.status = status;
        this.opsId = opsId;
        this.email = email;
        this.name = name;
        this.problems = problems;
    }
}

package com.memebattle.megahack.main.fragment.profile.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileStatus {
    @SerializedName("status")
    @Expose
    public boolean isOnline;

    @SerializedName("opsId")
    @Expose
    public String opsId;
    public ProfileStatus(){

    }
    public ProfileStatus(boolean isOnline, String opsId){
        super();
        this.isOnline = isOnline;
        this.opsId = opsId;
    }
}

package com.memebattle.megahack.auth.fragment.core.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignRequest {
    @SerializedName("operatorId")
    @Expose
    public String opsId;

    @SerializedName("status")
    @Expose
    public boolean status;
    public SignRequest(){

    }
    public SignRequest(String opsId, boolean status){
        super();
        this.opsId = opsId;
        this.status = status;
    }
}

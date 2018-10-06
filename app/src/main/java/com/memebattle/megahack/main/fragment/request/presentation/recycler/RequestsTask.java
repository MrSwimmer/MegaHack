package com.memebattle.megahack.main.fragment.request.presentation.recycler;

import com.memebattle.megahack.main.fragment.request.data.model.RequestTask;

public class RequestsTask {
    public String userId;
    public String time;
    public String requestId;
    public RequestsTask(String userId, String time){
        this.userId = userId;
        this.time = time;
    }
}

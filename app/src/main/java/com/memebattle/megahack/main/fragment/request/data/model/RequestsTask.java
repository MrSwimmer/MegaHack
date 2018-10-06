package com.memebattle.megahack.main.fragment.request.data.model;

public class RequestsTask {
    public String type;
    public String text;
    public String name;

    public RequestsTask(String type, String text, String name) {
        this.type = type;
        this.text = text;
        this.name = name;
    }

    public RequestsTask() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

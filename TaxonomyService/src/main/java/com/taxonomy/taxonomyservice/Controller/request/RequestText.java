package com.taxonomy.taxonomyservice.Controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RequestText {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

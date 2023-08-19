package com.taxonomy.taxonomyservice.Controller.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseText {

    private String[] words;


    public ResponseText(String[] words){
        this.words=words;
    }


    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }
}

package com.taxonomy.taxonomyservice.Model;

import jakarta.persistence.*;

@Entity
public class WordFrequency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String word;

    private int num;

    public String getId(){
        return word;
    }
    public void setId(String word){
        this.word=word;
    }

    public Integer getNum(){
        return num;
    }
    public void setNum(int num){
        this.num=num;
    }


}

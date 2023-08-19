package com.taxonomy.taxonomyservice.Services;


import com.taxonomy.taxonomyservice.Controller.request.RequestText;
import com.taxonomy.taxonomyservice.Controller.response.ResponseText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@EnableCaching
public class WordFrequencyService {
    HashMap<String,Integer> wordFrequencyMap;

    @Autowired

    public WordFrequencyService(){
        wordFrequencyMap=new HashMap<>();
    }
    public ResponseText wordFrequency(RequestText requestText){
        String[] words= requestText.getText().split(" ");

        for(String word:words){
            wordFrequencyMap.put(word,wordFrequencyMap.getOrDefault(word,0)+1);
        }
        return new ResponseText(words);
    }

    public Map<String, Integer> getFrequency(){
        return wordFrequencyMap;
    }
}

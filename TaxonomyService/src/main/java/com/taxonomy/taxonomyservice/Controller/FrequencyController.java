package com.taxonomy.taxonomyservice.Controller;

import com.taxonomy.taxonomyservice.Controller.request.RequestText;
import com.taxonomy.taxonomyservice.Controller.response.ResponseText;
import com.taxonomy.taxonomyservice.Repository.WordFrequencyRepo;
import com.taxonomy.taxonomyservice.Services.WordFrequencyService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class FrequencyController {
    private static final Logger logger =  Logger.getLogger(FrequencyController.class);

    private WordFrequencyRepo wordFrequencyRepo;

    @Autowired
    WordFrequencyService service;

    @PostMapping("/parse")
    public ResponseText parseText(@RequestBody RequestText request){
        logger.debug("Input required");
        return service.wordFrequency(request);
    }

    @GetMapping("/frequency")
    public Map<String,Integer> frequency(){
        Map<String, Integer> map= new HashMap<>();
        map= service.getFrequency();
        WordFrequencyRepo wordFrequencyRepo1 = wordFrequencyRepo;
        wordFrequencyRepo1.save(map);
        return map;

    }
}

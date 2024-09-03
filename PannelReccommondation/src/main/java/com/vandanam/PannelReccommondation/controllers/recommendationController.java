package com.vandanam.PannelReccommondation.controllers;

import com.vandanam.PannelReccommondation.models.Recommendation;
import com.vandanam.PannelReccommondation.services.RecommendationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class recommendationController {

    @Autowired
    RecommendationServices recommendationServices;

    @GetMapping("/recommendations/{connectionId}")
    public List<Recommendation> getRecommendations(@PathVariable Long connectionId){
         return recommendationServices.getAllRecommendations(connectionId);
    }
}

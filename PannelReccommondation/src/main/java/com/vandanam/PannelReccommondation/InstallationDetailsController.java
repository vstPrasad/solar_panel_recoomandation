package com.vandanam.PannelReccommondation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/installation")
public class InstallationDetailsController {

    @Autowired
    private InstallationDetailsService service;

    @GetMapping("/recommend")
    public List<InstallationDetailsDTO> getRecommendations(
            @RequestParam Double eastWestSpace,
            @RequestParam Double northSouthSpace,
            @RequestParam Double avgUnits,
            @RequestParam String spaceType) {

        return service.recommendPanels(eastWestSpace, northSouthSpace, avgUnits, spaceType);
    }
}

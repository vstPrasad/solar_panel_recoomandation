package com.vandanam.PannelReccommondation.controllers;

import com.vandanam.PannelReccommondation.dto.InstallationDetailsDTO;
import com.vandanam.PannelReccommondation.services.InstallationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/installation")
public class InstallationDetailsController {

    @Autowired
    private InstallationDetailsService service;

    @PostMapping
    public InstallationDetailsDTO addInstallation(@RequestBody InstallationDetailsDTO installationDetailsDTO){
            return  service.addInstallation(installationDetailsDTO);
    }


}

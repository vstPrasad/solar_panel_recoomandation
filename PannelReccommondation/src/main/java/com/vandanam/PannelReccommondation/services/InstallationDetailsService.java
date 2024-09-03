package com.vandanam.PannelReccommondation.services;

import com.vandanam.PannelReccommondation.dto.InstallationDetailsDTO;
import com.vandanam.PannelReccommondation.mappers.InstallationDetailsMapper;
import com.vandanam.PannelReccommondation.models.InstallationDetails;
import com.vandanam.PannelReccommondation.repositories.InstallationDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstallationDetailsService {

    @Autowired
    private InstallationDetailsRepository repository;

    @Autowired
    private InstallationDetailsMapper mapper;

    @Autowired
    RecommendationServices recommendationServices;
    public InstallationDetailsDTO addInstallation(InstallationDetailsDTO installationDetailsDTO){
        InstallationDetails installationDetails=mapper.toEntity(installationDetailsDTO);
        installationDetails= repository.save(installationDetails);
        recommendationServices.addRecommendations(installationDetails);
        return mapper.toDTO(installationDetails);
    }


}

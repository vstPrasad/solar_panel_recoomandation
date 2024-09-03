package com.vandanam.PannelReccommondation.mappers;

import com.vandanam.PannelReccommondation.dto.RecommendationDTO;
import com.vandanam.PannelReccommondation.models.Recommendation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface recommendationMapper {
    InstallationDetailsMapper INSTANCE = Mappers.getMapper(InstallationDetailsMapper.class);

    RecommendationDTO toDTO(Recommendation installationDetails);
    Recommendation toEntity(RecommendationDTO installationDetailsDTO);
}

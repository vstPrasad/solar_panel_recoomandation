package com.vandanam.PannelReccommondation;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InstallationDetailsMapper {
    InstallationDetailsMapper INSTANCE = Mappers.getMapper(InstallationDetailsMapper.class);

    InstallationDetailsDTO toDTO(InstallationDetails installationDetails);
    InstallationDetails toEntity(InstallationDetailsDTO installationDetailsDTO);
}
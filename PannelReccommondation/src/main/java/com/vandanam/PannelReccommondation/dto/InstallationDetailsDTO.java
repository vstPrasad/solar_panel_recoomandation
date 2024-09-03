package com.vandanam.PannelReccommondation.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InstallationDetailsDTO {
    private Long id;
    private Long connectionId;
    private String installationSpaceType;

    private Boolean isPreferredSpace;

    private Boolean isActive;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    private Double availableSpaceEastWestSqft;

    private Double availableSpaceSouthNorthSqft;

    private boolean isSelected;
}


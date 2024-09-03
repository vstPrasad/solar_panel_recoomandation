package com.vandanam.PannelReccommondation.dto;

import com.vandanam.PannelReccommondation.models.InstallationDetails;

public class RecommendationDTO {
    private Long id;

    private InstallationDetails installationId;

    private String installationSpaceType;

    private String panelType;

    private Double availableSpaceEastWestSqft;

    private Double availableSpaceSouthNorthSqft;

    private int maxPannelCount;
    private int requiredPannel;
    private Boolean isSelected;
}

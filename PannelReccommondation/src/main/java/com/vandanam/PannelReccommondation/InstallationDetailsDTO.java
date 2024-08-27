package com.vandanam.PannelReccommondation;

import lombok.Data;

@Data
public class InstallationDetailsDTO {
    private Long id;
    private Long connectionId;
    private String installableSpaceType;
    private Boolean isPreferredSpace;
    private Boolean isActive;
    private Double availableSpaceEastWestSqft;
    private Double availableSpaceSouthNorthSqft;
}
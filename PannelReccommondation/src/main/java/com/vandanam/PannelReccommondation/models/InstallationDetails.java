package com.vandanam.PannelReccommondation.models;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "installation_details")
public class InstallationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "connection_id")
    private Long connectionId;

    @Column(name = "installation_space_type")
    private String installationSpaceType;

    @Column(name = "is_preferred_space")
    private Boolean isPreferredSpace;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "date_updated")
    private LocalDateTime dateUpdated;

    @Column(name = "available_space_east_west_sqft")
    private Double availableSpaceEastWestSqft;

    @Column(name = "available_space_south_north_sqft")
    private Double availableSpaceSouthNorthSqft;

    @Column(name="is_selected")
    private boolean isSelected;

}
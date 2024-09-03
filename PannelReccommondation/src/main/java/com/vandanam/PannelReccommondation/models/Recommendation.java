package com.vandanam.PannelReccommondation.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recommendations")
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "installationId", referencedColumnName = "id")
    private InstallationDetails installationDetails;

    @Column(name = "installation_space_type")
    private String installationSpaceType;

    @Column(name = "panel_type")
    private String panelType;

    @Column(name = "available_space_east_west_sqft")
    private Double availableSpaceEastWestSqft;

    @Column(name = "available_space_south_north_sqft")
    private Double availableSpaceSouthNorthSqft;

    @Column(name = "max_pannel_count")
    private int maxPannelCount;

    @Column(name = "required_pannel")
    private int requiredPannel;

    @Column(name = "is_selected")
    private Boolean isSelected;

}

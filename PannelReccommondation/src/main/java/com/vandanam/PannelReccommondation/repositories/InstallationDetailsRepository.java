package com.vandanam.PannelReccommondation.repositories;

import com.vandanam.PannelReccommondation.models.InstallationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallationDetailsRepository extends JpaRepository<InstallationDetails, Long> {
    // Custom query methods can be defined here if needed
}

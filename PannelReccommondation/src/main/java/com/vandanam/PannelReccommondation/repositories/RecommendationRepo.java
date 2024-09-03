package com.vandanam.PannelReccommondation.repositories;

import com.vandanam.PannelReccommondation.models.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecommendationRepo extends JpaRepository<Recommendation,Long> {
    @Query(value = "SELECT r.* FROM recommendations r " +
            "JOIN installation_details i ON r.installation_id = i.id " +
            "WHERE i.connection_id = :connectionId",
            nativeQuery = true)
    List<Recommendation> findRecommendations(@Param("connectionId") Long connectionId);
}

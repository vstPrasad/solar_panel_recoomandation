package com.vandanam.PannelReccommondation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstallationDetailsService {

    @Autowired
    private InstallationDetailsRepository repository;

    @Autowired
    private InstallationDetailsMapper mapper;

    public List<InstallationDetailsDTO> recommendPanels(Double eastWestSpace, Double northSouthSpace, Double avgUnits, String spaceType) {
        List<InstallationDetailsDTO> recommendations = new ArrayList<>();

        if (spaceType.equalsIgnoreCase("clay")) {
            recommendations.addAll(getStaticPanelRecommendations(eastWestSpace, northSouthSpace, avgUnits));
        } else {
            recommendations.addAll(getDynamicPanelRecommendations(eastWestSpace, northSouthSpace, avgUnits));
            recommendations.addAll(getStaticPanelRecommendations(eastWestSpace, northSouthSpace, avgUnits));
        }

        return recommendations;
    }

    private List<InstallationDetailsDTO> getDynamicPanelRecommendations(Double eastWestSpace, Double northSouthSpace, Double avgUnits) {
        List<InstallationDetailsDTO> recommendations = new ArrayList<>();

        int kw = 1;
        while (canFitPanel(eastWestSpace, northSouthSpace, kw, 9.0, 9.0)) {
            InstallationDetailsDTO recommendation = new InstallationDetailsDTO();
            recommendation.setAvailableSpaceEastWestSqft(eastWestSpace);
            recommendation.setAvailableSpaceSouthNorthSqft(northSouthSpace);
            recommendation.setInstallableSpaceType("dynamic");
            recommendations.add(recommendation);
            kw++;
        }

        return recommendations;
    }

    private List<InstallationDetailsDTO> getStaticPanelRecommendations(Double eastWestSpace, Double northSouthSpace, Double avgUnits) {
        List<InstallationDetailsDTO> recommendations = new ArrayList<>();

        int kw = 1;
        while (canFitPanel(eastWestSpace, northSouthSpace, kw, 9.0, 4.5)) {
            InstallationDetailsDTO recommendation = new InstallationDetailsDTO();
            recommendation.setAvailableSpaceEastWestSqft(eastWestSpace);
            recommendation.setAvailableSpaceSouthNorthSqft(northSouthSpace);
            recommendation.setInstallableSpaceType("static");
            recommendations.add(recommendation);
            kw++;
        }

        return recommendations;
    }

    private boolean canFitPanel(Double eastWestSpace, Double northSouthSpace, int kw, Double panelEW, Double panelNS) {
        // For dynamic panel
        if (panelEW.equals(9.0) && panelNS.equals(9.0)) {
            return (eastWestSpace >= panelEW && northSouthSpace >= (kw * panelNS));
        }
        // For static panel
        if (panelEW.equals(9.0) && panelNS.equals(4.5)) {
            return (eastWestSpace >= (kw * panelEW) && northSouthSpace >= panelNS);
        }
        return false;
    }
}

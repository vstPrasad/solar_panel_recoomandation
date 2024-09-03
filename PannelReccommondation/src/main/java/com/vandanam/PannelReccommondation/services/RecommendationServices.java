package com.vandanam.PannelReccommondation.services;

import com.vandanam.PannelReccommondation.models.InstallationDetails;
import com.vandanam.PannelReccommondation.models.Recommendation;
import com.vandanam.PannelReccommondation.repositories.RecommendationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServices {

    @Autowired
    RecommendationRepo recommendationRepo;

    public void addRecommendations(InstallationDetails installationDetails) {
        double staticLength = 9;
        double staticWidth = 4.5;

        double dynamicLength = 9;
        double dynamicWidth = 9;
        int units=80;
        int kw;
        if(units%100>0){
            kw=(units/100)+1;
        }else{
            kw=units/100;
        }



        if (installationDetails.getInstallationSpaceType().equalsIgnoreCase("clay")  || installationDetails.getInstallationSpaceType().equalsIgnoreCase("slab")
                || installationDetails.getInstallationSpaceType().equalsIgnoreCase("openspace")  || installationDetails.getInstallationSpaceType().equalsIgnoreCase("metalsheet") ) {
            if (installationDetails.getInstallationSpaceType().equalsIgnoreCase("slab")
                    || installationDetails.getInstallationSpaceType().equalsIgnoreCase("openspace") || installationDetails.getInstallationSpaceType().equalsIgnoreCase("metalsheet")) {
                int l = (int) (installationDetails.getAvailableSpaceEastWestSqft() / 9);
                int b = (int) (installationDetails.getAvailableSpaceSouthNorthSqft() / 9);
                int max = l * b;
                Recommendation recommendation=setData(installationDetails,kw);
                recommendation.setMaxPannelCount(max);
                recommendation.setPanelType("dynamic");
                if(max>kw) {
                    recommendationRepo.save(recommendation);
                }
            }
            int l = (int) (installationDetails.getAvailableSpaceEastWestSqft() / 9);
            int b = (int) (installationDetails.getAvailableSpaceSouthNorthSqft() / 4.5);
            int max1 = l * b;
            int l1 = (int) (installationDetails.getAvailableSpaceEastWestSqft() / 4.5);
            int b1= (int) (installationDetails.getAvailableSpaceSouthNorthSqft() / 9);
            int max2=l1*b1;
            int max = Math.max(max2,max1);
            Recommendation recommendation1=setData(installationDetails,kw);
            recommendation1.setMaxPannelCount(max);
            recommendation1.setPanelType("static");
            recommendation1.setId(null);
            if(max>kw) {
                recommendationRepo.save(recommendation1);
            }
        }
    }


         public List<Recommendation> getAllRecommendations(Long connectionId){
             return recommendationRepo.findRecommendations(connectionId);
         }

         private Recommendation setData(InstallationDetails installationDetails,int kw){
             Recommendation recommendation=new Recommendation();
             recommendation.setAvailableSpaceEastWestSqft(installationDetails.getAvailableSpaceEastWestSqft());
             recommendation.setAvailableSpaceSouthNorthSqft(installationDetails.getAvailableSpaceSouthNorthSqft());
             recommendation.setInstallationDetails(installationDetails);
             recommendation.setInstallationSpaceType(installationDetails.getInstallationSpaceType());
             recommendation.setRequiredPannel(kw);
             return recommendation;
         }

}

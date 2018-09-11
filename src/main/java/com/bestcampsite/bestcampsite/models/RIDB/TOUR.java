package com.bestcampsite.bestcampsite.models.RIDB;

public class TOUR {

    private String CreatedDate;

    private int FacilityID;

    private String LastUpdatedDate;

    private String TourAccessible;

    private String TourDescription;

    private transient String TourDuration;

    private transient String TourID;

    private String TourName;

    private String TourType;

    public TOUR() {
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public int getFacilityID() {
        return FacilityID;
    }

    public void setFacilityID(int facilityID) {
        FacilityID = facilityID;
    }

    public String getLastUpdatedDate() {
        return LastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        LastUpdatedDate = lastUpdatedDate;
    }

    public String getTourAccessible() {
        return TourAccessible;
    }

    public void setTourAccessible(String tourAccessible) {
        TourAccessible = tourAccessible;
    }

    public String getTourDescription() {
        return TourDescription;
    }

    public void setTourDescription(String tourDescription) {
        TourDescription = tourDescription;
    }

    public String getTourDuration() {
        return TourDuration;
    }

    public void setTourDuration(String tourDuration) {
        TourDuration = tourDuration;
    }

    public String getTourID() {
        return TourID;
    }

    public void setTourID(String tourID) {
        TourID = tourID;
    }

    public String getTourName() {
        return TourName;
    }

    public void setTourName(String tourName) {
        TourName = tourName;
    }

    public String getTourType() {
        return TourType;
    }

    public void setTourType(String tourType) {
        TourType = tourType;
    }
}

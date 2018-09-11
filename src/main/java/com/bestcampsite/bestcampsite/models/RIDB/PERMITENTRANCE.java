package com.bestcampsite.bestcampsite.models.RIDB;

public class PERMITENTRANCE {

    private String CreatedDate;

    private String District;

    private transient String FacilityID;

    private String LastUpdatedDate;

    private transient String Latitude;

    private transient String Longitude;

    private String PermitEntranceAccessible;

    private String PermitEntranceDescription;

    private transient String PermitEntranceID;

    private String PermitEntranceName;

    private String PermitEntranceType;

    private String Town;

    public PERMITENTRANCE() {
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getFacilityID() {
        return FacilityID;
    }

    public void setFacilityID(String facilityID) {
        FacilityID = facilityID;
    }

    public String getLastUpdatedDate() {
        return LastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        LastUpdatedDate = lastUpdatedDate;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPermitEntranceAccessible() {
        return PermitEntranceAccessible;
    }

    public void setPermitEntranceAccessible(String permitEntranceAccessible) {
        PermitEntranceAccessible = permitEntranceAccessible;
    }

    public String getPermitEntranceDescription() {
        return PermitEntranceDescription;
    }

    public void setPermitEntranceDescription(String permitEntranceDescription) {
        PermitEntranceDescription = permitEntranceDescription;
    }

    public String getPermitEntranceID() {
        return PermitEntranceID;
    }

    public void setPermitEntranceID(String permitEntranceID) {
        PermitEntranceID = permitEntranceID;
    }

    public String getPermitEntranceName() {
        return PermitEntranceName;
    }

    public void setPermitEntranceName(String permitEntranceName) {
        PermitEntranceName = permitEntranceName;
    }

    public String getPermitEntranceType() {
        return PermitEntranceType;
    }

    public void setPermitEntranceType(String permitEntranceType) {
        PermitEntranceType = permitEntranceType;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        Town = town;
    }
}

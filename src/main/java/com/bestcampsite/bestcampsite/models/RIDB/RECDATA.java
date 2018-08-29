package com.bestcampsite.bestcampsite.models.RIDB;

public class RECDATA {

    private String FacilityDescription;

    private String FacilityUseFeeDescription;

    private String FacilityMapURL;

    private GEOJSON GEOJSON;

    private transient EVENT[] EVENT;

    private ORGANIZATION[] ORGANIZATION;

    private String FacilityTypeDescription;

    private transient PERMITENTRANCE[] PERMITENTRANCE;

    private int FacilityID;

    private String FacilityReservationURL;

    private transient ENTITYMEDIA[] MEDIA;

    private LINK[] LINK;

    private String StayLimit;

    private float FacilityLongitude;

    private CAMPSITE[] CAMPSITE;

    private String FacilityEmail;

    private float FacilityLatitude;

    private int LegacyFacilityID;

    private String OrgFacilityID;

    private FACILITYADDRESS[] FACILITYADDRESS;

    private String FacilityName;

    private String LastUpdatedDate;

    private String FacilityAdaAccess;

    private String FacilityDirections;

    private String FacilityPhone;

    private String Keywords;

    private ACTIVITY[] ACTIVITY;

    private transient TOUR[] TOUR;

    public RECDATA() {
    }

    public String getFacilityDescription() {
        return FacilityDescription;
    }

    public void setFacilityDescription(String facilityDescription) {
        FacilityDescription = facilityDescription;
    }

    public String getFacilityUseFeeDescription() {
        return FacilityUseFeeDescription;
    }

    public void setFacilityUseFeeDescription(String facilityUseFeeDescription) {
        FacilityUseFeeDescription = facilityUseFeeDescription;
    }

    public String getFacilityMapURL() {
        return FacilityMapURL;
    }

    public void setFacilityMapURL(String facilityMapURL) {
        FacilityMapURL = facilityMapURL;
    }

    public GEOJSON getGEOJSON() {
        return GEOJSON;
    }

    public void setGEOJSON(GEOJSON GEOJSON) {
        this.GEOJSON = GEOJSON;
    }

    public ORGANIZATION[] getORGANIZATION() {
        return ORGANIZATION;
    }

    public void setORGANIZATION(ORGANIZATION[] ORGANIZATION) {
        this.ORGANIZATION = ORGANIZATION;
    }

    public String getFacilityTypeDescription() {
        return FacilityTypeDescription;
    }

    public void setFacilityTypeDescription(String facilityTypeDescription) {
        FacilityTypeDescription = facilityTypeDescription;
    }

    public int getFacilityID() {
        return FacilityID;
    }

    public void setFacilityID(int facilityID) {
        FacilityID = facilityID;
    }

    public String getFacilityReservationURL() {
        return FacilityReservationURL;
    }

    public void setFacilityReservationURL(String facilityReservationURL) {
        FacilityReservationURL = facilityReservationURL;
    }

    public LINK[] getLINK() {
        return LINK;
    }

    public void setLINK(LINK[] LINK) {
        this.LINK = LINK;
    }

    public String getStayLimit() {
        return StayLimit;
    }

    public void setStayLimit(String stayLimit) {
        StayLimit = stayLimit;
    }

    public float getFacilityLongitude() {
        return FacilityLongitude;
    }

    public void setFacilityLongitude(float facilityLongitude) {
        FacilityLongitude = facilityLongitude;
    }

    public com.bestcampsite.bestcampsite.models.RIDB.CAMPSITE[] getCAMPSITE() {
        return CAMPSITE;
    }

    public void setCAMPSITE(com.bestcampsite.bestcampsite.models.RIDB.CAMPSITE[] CAMPSITE) {
        this.CAMPSITE = CAMPSITE;
    }

    public String getFacilityEmail() {
        return FacilityEmail;
    }

    public void setFacilityEmail(String facilityEmail) {
        FacilityEmail = facilityEmail;
    }

    public float getFacilityLatitude() {
        return FacilityLatitude;
    }

    public void setFacilityLatitude(float facilityLatitude) {
        FacilityLatitude = facilityLatitude;
    }

    public int getLegacyFacilityID() {
        return LegacyFacilityID;
    }

    public void setLegacyFacilityID(int legacyFacilityID) {
        LegacyFacilityID = legacyFacilityID;
    }

    public String getOrgFacilityID() {
        return OrgFacilityID;
    }

    public void setOrgFacilityID(String orgFacilityID) {
        OrgFacilityID = orgFacilityID;
    }

    public FACILITYADDRESS[] getFACILITYADDRESS() {
        return FACILITYADDRESS;
    }

    public void setFACILITYADDRESS(FACILITYADDRESS[] FACILITYADDRESS) {
        this.FACILITYADDRESS = FACILITYADDRESS;
    }

    public String getFacilityName() {
        return FacilityName;
    }

    public void setFacilityName(String facilityName) {
        FacilityName = facilityName;
    }

    public String getLastUpdatedDate() {
        return LastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        LastUpdatedDate = lastUpdatedDate;
    }

    public String getFacilityAdaAccess() {
        return FacilityAdaAccess;
    }

    public void setFacilityAdaAccess(String facilityAdaAccess) {
        FacilityAdaAccess = facilityAdaAccess;
    }

    public String getFacilityDirections() {
        return FacilityDirections;
    }

    public void setFacilityDirections(String facilityDirections) {
        FacilityDirections = facilityDirections;
    }

    public String getFacilityPhone() {
        return FacilityPhone;
    }

    public void setFacilityPhone(String facilityPhone) {
        FacilityPhone = facilityPhone;
    }

    public String getKeywords() {
        return Keywords;
    }

    public void setKeywords(String keywords) {
        Keywords = keywords;
    }

    public ACTIVITY[] getACTIVITY() {
        return ACTIVITY;
    }

    public void setACTIVITY(ACTIVITY[] ACTIVITY) {
        this.ACTIVITY = ACTIVITY;
    }

    public com.bestcampsite.bestcampsite.models.RIDB.EVENT[] getEVENT() {
        return EVENT;
    }

    public void setEVENT(com.bestcampsite.bestcampsite.models.RIDB.EVENT[] EVENT) {
        this.EVENT = EVENT;
    }

    public com.bestcampsite.bestcampsite.models.RIDB.PERMITENTRANCE[] getPERMITENTRANCE() {
        return PERMITENTRANCE;
    }

    public void setPERMITENTRANCE(com.bestcampsite.bestcampsite.models.RIDB.PERMITENTRANCE[] PERMITENTRANCE) {
        this.PERMITENTRANCE = PERMITENTRANCE;
    }

    public ENTITYMEDIA[] getMEDIA() {
        return MEDIA;
    }

    public void setMEDIA(ENTITYMEDIA[] MEDIA) {
        this.MEDIA = MEDIA;
    }

    public com.bestcampsite.bestcampsite.models.RIDB.TOUR[] getTOUR() {
        return TOUR;
    }

    public void setTOUR(com.bestcampsite.bestcampsite.models.RIDB.TOUR[] TOUR) {
        this.TOUR = TOUR;
    }

}

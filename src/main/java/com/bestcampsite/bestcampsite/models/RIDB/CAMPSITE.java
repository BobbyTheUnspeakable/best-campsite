package com.bestcampsite.bestcampsite.models.RIDB;

import java.lang.reflect.Array;

public class CAMPSITE {

    private int CampsiteID;

    private ATTRIBUTE[] ATTRIBUTES;

    private String CreatedDate;

    private PERMITEQUIP[] PERMITTEDEQUIPMENT;

    private transient ENTITYMEDIA[] ENTITYMEDIA;

    private String Loop;

    private int FacilityID;

    private String CampsiteName;

    private Boolean CampsiteAccessible;

    private String CampsiteType;

    private String TypeOfUse;

    private String LastUpdatedDate;

    public CAMPSITE() {
    }

    public int getCampsiteID() {
        return CampsiteID;
    }

    public void setCampsiteID(int campsiteID) {
        CampsiteID = campsiteID;
    }

    public ATTRIBUTE[] getATTRIBUTES() {
        return ATTRIBUTES;
    }

    public void setATTRIBUTES(ATTRIBUTE[] ATTRIBUTES) {
        this.ATTRIBUTES = ATTRIBUTES;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public PERMITEQUIP[] getPERMITTEDEQUIPMENT() {
        return PERMITTEDEQUIPMENT;
    }

    public void setPERMITTEDEQUIPMENT(PERMITEQUIP[] PERMITTEDEQUIPMENT) {
        this.PERMITTEDEQUIPMENT = PERMITTEDEQUIPMENT;
    }

    public com.bestcampsite.bestcampsite.models.RIDB.ENTITYMEDIA[] getENTITYMEDIA() {
        return ENTITYMEDIA;
    }

    public void setENTITYMEDIA(com.bestcampsite.bestcampsite.models.RIDB.ENTITYMEDIA[] ENTITYMEDIA) {
        this.ENTITYMEDIA = ENTITYMEDIA;
    }

    public String getLoop() {
        return Loop;
    }

    public void setLoop(String loop) {
        Loop = loop;
    }

    public int getFacilityID() {
        return FacilityID;
    }

    public void setFacilityID(int facilityID) {
        FacilityID = facilityID;
    }

    public String getCampsiteName() {
        return CampsiteName;
    }

    public void setCampsiteName(String campsiteName) {
        CampsiteName = campsiteName;
    }

    public Boolean getCampsiteAccessible() {
        return CampsiteAccessible;
    }

    public void setCampsiteAccessible(Boolean campsiteAccessible) {
        CampsiteAccessible = campsiteAccessible;
    }

    public String getCampsiteType() {
        return CampsiteType;
    }

    public void setCampsiteType(String campsiteType) {
        CampsiteType = campsiteType;
    }

    public String getTypeOfUse() {
        return TypeOfUse;
    }

    public void setTypeOfUse(String typeOfUse) {
        TypeOfUse = typeOfUse;
    }

    public String getLastUpdatedDate() {
        return LastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        LastUpdatedDate = lastUpdatedDate;
    }
}

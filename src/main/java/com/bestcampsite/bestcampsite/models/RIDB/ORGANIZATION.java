package com.bestcampsite.bestcampsite.models.RIDB;

public class ORGANIZATION {

    private int OrgID;

    private String OrgImageURL;

    private String OrgURLText;

    private String OrgURLAddress;

    private String OrgType;

    private String OrgName;

    private String OrgJurisdictionType;

    private int OrgParentID;

    private String LastUpdatedDate;

    public ORGANIZATION() {
    }

    public int getOrgID() {
        return OrgID;
    }

    public void setOrgID(int orgID) {
        OrgID = orgID;
    }

    public String getOrgImageURL() {
        return OrgImageURL;
    }

    public void setOrgImageURL(String orgImageURL) {
        OrgImageURL = orgImageURL;
    }

    public String getOrgURLText() {
        return OrgURLText;
    }

    public void setOrgURLText(String orgURLText) {
        OrgURLText = orgURLText;
    }

    public String getOrgURLAddress() {
        return OrgURLAddress;
    }

    public void setOrgURLAddress(String orgURLAddress) {
        OrgURLAddress = orgURLAddress;
    }

    public String getOrgType() {
        return OrgType;
    }

    public void setOrgType(String orgType) {
        OrgType = orgType;
    }

    public String getOrgName() {
        return OrgName;
    }

    public void setOrgName(String orgName) {
        OrgName = orgName;
    }

    public String getOrgJurisdictionType() {
        return OrgJurisdictionType;
    }

    public void setOrgJurisdictionType(String orgJurisdictionType) {
        OrgJurisdictionType = orgJurisdictionType;
    }

    public int getOrgParentID() {
        return OrgParentID;
    }

    public void setOrgParentID(int orgParentID) {
        OrgParentID = orgParentID;
    }

    public String getLastUpdatedDate() {
        return LastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        LastUpdatedDate = lastUpdatedDate;
    }
}

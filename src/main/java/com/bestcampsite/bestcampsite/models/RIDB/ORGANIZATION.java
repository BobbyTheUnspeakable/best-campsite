package com.bestcampsite.bestcampsite.models.RIDB;

public class ORGANIZATION {

    private transient String OrgID;

    private String OrgImageURL;

    private String OrgURLText;

    private String OrgURLAddress;

    private String OrgType;

    private String OrgName;

    private String OrgJurisdictionType;

    private transient String OrgParentID;

    private String LastUpdatedDate;

    public ORGANIZATION() {
    }

    public String getOrgID() {
        return OrgID;
    }

    public void setOrgID(String orgID) {
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

    public String getOrgParentID() {
        return OrgParentID;
    }

    public void setOrgParentID(String orgParentID) {
        OrgParentID = orgParentID;
    }

    public String getLastUpdatedDate() {
        return LastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        LastUpdatedDate = lastUpdatedDate;
    }
}

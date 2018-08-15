package com.bestcampsite.bestcampsite.models.RIDB;

public class ACTIVITY {

    private String FacilityActivityDescription;

    private int FacilityID;

    private String FacilityActivityFeeDescription;

    private String ActivityName;

    private int ActivityID;

    public ACTIVITY() {
    }

    public String getFacilityActivityDescription() {
        return FacilityActivityDescription;
    }

    public void setFacilityActivityDescription(String facilityActivityDescription) {
        FacilityActivityDescription = facilityActivityDescription;
    }

    public int getFacilityID() {
        return FacilityID;
    }

    public void setFacilityID(int facilityID) {
        FacilityID = facilityID;
    }

    public String getFacilityActivityFeeDescription() {
        return FacilityActivityFeeDescription;
    }

    public void setFacilityActivityFeeDescription(String facilityActivityFeeDescription) {
        FacilityActivityFeeDescription = facilityActivityFeeDescription;
    }

    public String getActivityName() {
        return ActivityName;
    }

    public void setActivityName(String activityName) {
        ActivityName = activityName;
    }

    public int getActivityID() {
        return ActivityID;
    }

    public void setActivityID(int activityID) {
        ActivityID = activityID;
    }
}

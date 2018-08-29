package com.bestcampsite.bestcampsite.models.RIDB;

public class SEARCH_PARAMETERS {

    private String QUERY;

    private String SORT;

    private int OFFSET;

    private String STATE;

    private int LIMIT;

    private int ACTIVITY;

    public SEARCH_PARAMETERS() {
    }

    public String getQUERY() {
        return QUERY;
    }

    public void setQUERY(String QUERY) {
        this.QUERY = QUERY;
    }

    public String getSORT() {
        return SORT;
    }

    public void setSORT(String SORT) {
        this.SORT = SORT;
    }

    public int getOFFSET() {
        return OFFSET;
    }

    public void setOFFSET(int OFFSET) {
        this.OFFSET = OFFSET;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public int getLIMIT() {
        return LIMIT;
    }

    public void setLIMIT(int LIMIT) {
        this.LIMIT = LIMIT;
    }

    public int getACTIVITY() {
        return ACTIVITY;
    }

    public void setACTIVITY(int ACTIVITY) {
        this.ACTIVITY = ACTIVITY;
    }
}

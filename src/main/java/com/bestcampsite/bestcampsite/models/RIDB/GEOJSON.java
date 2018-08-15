package com.bestcampsite.bestcampsite.models.RIDB;

public class GEOJSON {

    private String TYPE;

    private int[] COORDINATES;

    public GEOJSON() {
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public int[] getCOORDINATES() {
        return COORDINATES;
    }

    public void setCOORDINATES(int[] COORDINATES) {
        this.COORDINATES = COORDINATES;
    }
}

package com.bestcampsite.bestcampsite.models.RIDB;

public class GEOJSON {

    private String TYPE;

    private float[] COORDINATES;

    public GEOJSON() {
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public float[] getCOORDINATES() {
        return COORDINATES;
    }

    public void setCOORDINATES(float[] COORDINATES) {
        this.COORDINATES = COORDINATES;
    }
}

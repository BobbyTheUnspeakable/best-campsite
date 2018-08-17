package com.bestcampsite.bestcampsite.models.RIDB;

public class ENTITYMEDIA {

    private transient String Credits;

    private transient String Description;

    private transient String EmbedCode;

    private int EntityID;

    private int EntityMediaID;

    private String EntityType;

    private int Height;

    private String MediaType;

    private transient String Subtitle;

    private transient String Title;

    private String URL;

    private int Width;

    public ENTITYMEDIA() {
    }

    public String getCredits() {
        return Credits;
    }

    public void setCredits(String credits) {
        Credits = credits;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getEmbedCode() {
        return EmbedCode;
    }

    public void setEmbedCode(String embedCode) {
        EmbedCode = embedCode;
    }

    public int getEntityID() {
        return EntityID;
    }

    public void setEntityID(int entityID) {
        EntityID = entityID;
    }

    public int getEntityMediaID() {
        return EntityMediaID;
    }

    public void setEntityMediaID(int entityMediaID) {
        EntityMediaID = entityMediaID;
    }

    public String getEntityType() {
        return EntityType;
    }

    public void setEntityType(String entityType) {
        EntityType = entityType;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public String getMediaType() {
        return MediaType;
    }

    public void setMediaType(String mediaType) {
        MediaType = mediaType;
    }

    public String getSubtitle() {
        return Subtitle;
    }

    public void setSubtitle(String subtitle) {
        Subtitle = subtitle;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }
}

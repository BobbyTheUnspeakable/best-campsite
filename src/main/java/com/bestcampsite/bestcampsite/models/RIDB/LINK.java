package com.bestcampsite.bestcampsite.models.RIDB;

public class LINK {

    private int EntityID;

    private String Description;

    private String LinkType;

    private String Title;

    private int EntityLinkID;

    private String EntityType;

    private String URL;

    public LINK() {
    }

    public int getEntityID() {
        return EntityID;
    }

    public void setEntityID(int entityID) {
        EntityID = entityID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLinkType() {
        return LinkType;
    }

    public void setLinkType(String linkType) {
        LinkType = linkType;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getEntityLinkID() {
        return EntityLinkID;
    }

    public void setEntityLinkID(int entityLinkID) {
        EntityLinkID = entityLinkID;
    }

    public String getEntityType() {
        return EntityType;
    }

    public void setEntityType(String entityType) {
        EntityType = entityType;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}

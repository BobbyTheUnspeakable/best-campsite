package com.bestcampsite.bestcampsite.models.RIDB;

public class LINK {

    private transient String EntityID;

    private String Description;

    private String LinkType;

    private String Title;

    private transient String EntityLinkID;

    private String EntityType;

    private String URL;

    public LINK() {
    }

    public String getEntityID() {
        return EntityID;
    }

    public void setEntityID(String entityID) {
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

    public String getEntityLinkID() {
        return EntityLinkID;
    }

    public void setEntityLinkID(String entityLinkID) {
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

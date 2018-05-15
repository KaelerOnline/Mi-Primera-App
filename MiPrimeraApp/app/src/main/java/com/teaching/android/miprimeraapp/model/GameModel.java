package com.teaching.android.miprimeraapp.model;

public class GameModel {

    private int id;
    private int name;
    private int description;
    private int officialWebsiteUrl;
    private int iconDrawable;
    private int backgroundDrawable;

    public GameModel(int id, int name, int description, int officialWebsiteUrl, int iconDrawable, int backgroundDrawable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.officialWebsiteUrl = officialWebsiteUrl;
        this.iconDrawable = iconDrawable;
        this.backgroundDrawable = backgroundDrawable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getOfficialWebsiteUrl() {
        return officialWebsiteUrl;
    }

    public void setOfficialWebsiteUrl(int officialWebsiteUrl) {
        this.officialWebsiteUrl = officialWebsiteUrl;
    }

    public int getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(int iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public int getBackgroundDrawable() {
        return backgroundDrawable;
    }

    public void setBackgroundDrawable(int backgroundDrawable) {
        this.backgroundDrawable = backgroundDrawable;
    }

}

package com.dzaky.perabotoemah;

public class ItemModel {

    private String title;
    private String description;
    private String thumbnail;

    public ItemModel(String title, String description, String thumbnail) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

}

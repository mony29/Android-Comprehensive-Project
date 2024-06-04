package com.example.comphrehensivehomework.model;

public class LearningItem {
    private Integer imageId;
    private String title;
    private String content;

    public LearningItem() {
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LearningItem(Integer imageId, String title, String content) {
        this.imageId = imageId;
        this.title = title;
        this.content = content;
    }
}

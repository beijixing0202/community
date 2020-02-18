package net.bill99.community.community.entity;

/**
 * @Author: wsy
 * @Description:
 * @Date: Create in 22:04 2020/2/18
 */
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Integer creator;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCouunt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getLikeCouunt() {
        return likeCouunt;
    }

    public void setLikeCouunt(Integer likeCouunt) {
        this.likeCouunt = likeCouunt;
    }
}
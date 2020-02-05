package net.add1s.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author pj.w@qq.com
 */
public class Article {

    private Long id;
    private String title;
    private String author;
    private String content;
    /**
     * 相对于/resources/articles/*的相对路径
     */
    private String contentPath;
    private Date createTime;
    private Date updateTime;
    private Long likeCount;
    private Long views;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentPath() {
        return contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    /**
     * 格外属性
     */
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /*************
     * 日期格式化配置不知道为什么失效，手动格式化
     ************/

    private String createDate;
    private String updateDate;

    public String getCreateDate() {
        if (getCreateTime() != null) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getCreateTime());
        }
        return null;
    }

    public String getUpdateDate() {
        if (getUpdateTime() != null) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getUpdateTime());
        }
        return null;
    }
}

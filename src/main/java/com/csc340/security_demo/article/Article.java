package com.csc340.security_demo.article;

import com.csc340.security_demo.user.User;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long articleId;

    @ManyToOne
    @JoinColumn(name = "writerId")
    private User writer;

    private String title;


    @Lob
    private String contents;


    private String preview;


    private Date createdAt;


    private Date updatedAt;


    public Article() {
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public Article(User writer, String title, String contents, Date createdAt, Date updatedAt) {
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
    }

    public Article(User writer, String title, String contents, Date createdAt) {
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createdAt=createdAt;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

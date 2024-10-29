package com.csc340.security_demo.subscription;

import com.csc340.security_demo.article.Article;
import com.csc340.security_demo.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "articleId")
    private Article article;

    public Subscription(long id, User customer, Article article) {
        this.id = id;
        this.customer = customer;
        this.article = article;
    }

    public Subscription( User customer, Article article) {
        this.customer = customer;
        this.article = article;
    }

    public Subscription() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}

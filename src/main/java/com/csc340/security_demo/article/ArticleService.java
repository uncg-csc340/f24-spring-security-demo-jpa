package com.csc340.security_demo.article;

import com.csc340.security_demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository repo;


    @Autowired
    UserRepository userRepo;
    public List<Article> getAllArticles(){
        return repo.findAll();
    }

    public Article getArticleById(long id){
        return repo.getReferenceById(id);
    }

    public void saveArticle(Article article) {
        article.setPreview(article.getContents().substring(0, 50));
        article.setCreatedAt(new Date(System.currentTimeMillis()));
        article.setUpdatedAt(new Date(System.currentTimeMillis()));
        repo.save(article);
    }

    public void updateArticle(Article article){
        article.setPreview(article.getContents().substring(0, 50));
        article.setUpdatedAt(new Date(System.currentTimeMillis()));
        repo.save(article);
    }

    public void deleteArticleById(long articleId) {
        repo.deleteById(articleId);
    }
}

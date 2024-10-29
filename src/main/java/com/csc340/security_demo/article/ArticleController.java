package com.csc340.security_demo.article;

import com.csc340.security_demo.subscription.SubscriptionService;
import com.csc340.security_demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @Autowired
    UserService userService;


    @Autowired
    SubscriptionService subsService;

    @GetMapping("/articles/all")
    public String getAllArticles(Model model) {
        model.addAttribute("title", "All Articles");
        model.addAttribute("articleList", articleService.getAllArticles());
        return "article/article-list";
    }

    @GetMapping("/articles/{articleId}")
    public String getArticleById(@PathVariable long articleId, Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        long currentUserId = userService.getUserByUserName(name).getUserId();

        Article article = articleService.getArticleById(articleId);
        model.addAttribute("isOwner", article.getWriter().getUserId() == currentUserId);
        model.addAttribute("article", article);
        model.addAttribute("canFavorite", subsService.getOneSubscription(articleId, currentUserId)==null);
        return "article/article-details";
    }

    @GetMapping("/WRITER/articles/createForm")
    public String showCreateForm() {
        return "article/article-create";
    }

    @PostMapping("/WRITER/articles/new")
    public String createArticle(Article article) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        article.setWriter(userService.getUser(userService.getUserByUserName(name).getUserId()));
        articleService.saveArticle(article);
        return "redirect:/articles/all";
    }

    @GetMapping("/WRITER/articles/update/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        model.addAttribute("article", articleService.getArticleById(id));
        return "article/article-update";
    }

    @PostMapping("/WRITER/articles/update")
    public String update(Article article) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        article.setWriter(userService.getUser(userService.getUserByUserName(name).getUserId()));
        articleService.updateArticle(article);
        return "redirect:/articles/" + article.getArticleId();
    }

    @GetMapping("/WRITER/articles/delete/{articleId}")
    public String deleteArticleById(@PathVariable long articleId) {
        articleService.deleteArticleById(articleId);
        return "redirect:/articles/all";
    }
}

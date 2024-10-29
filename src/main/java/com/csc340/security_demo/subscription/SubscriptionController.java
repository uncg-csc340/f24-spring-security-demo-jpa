package com.csc340.security_demo.subscription;

import com.csc340.security_demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SubscriptionController {

    @Autowired
    SubscriptionService service;

    @Autowired
    UserService userService;

    @GetMapping("/subs/add/{articleId}")
    public String createNewSubscription(@PathVariable long articleId) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        long currentUserId = userService.getUserByUserName(name).getUserId();
        service.addNewSubscription(articleId, currentUserId);
        return "redirect:/subs/current";
    }

    @GetMapping("/subs/{userId}")
    public String getSubsByUser(@PathVariable long userId, Model model) {
        model.addAttribute("subsList", service.getSubscriptionsByUser(userId));
        model.addAttribute("title", "User #" + userId + " Favorites");
        model.addAttribute("isSubscriber", false);
        return "article/subs-list";
    }

    @GetMapping("/subs/current")
    public String getSubsByCurrentUser(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        long currentUserId = userService.getUserByUserName(name).getUserId();
        model.addAttribute("subsList", service.getSubscriptionsByUser(currentUserId));
        model.addAttribute("title", "User #" + currentUserId + " Favorites");
        model.addAttribute("isSubscriber", true);
        return "article/subs-list";
    }

    @GetMapping("/subs/remove/{id}")
    public String removeSub(@PathVariable long id) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        long currentUserId = userService.getUserByUserName(name).getUserId();
        service.removeSub(id);
        return "redirect:/subs/" + currentUserId;
    }

    @GetMapping("/subs/removeByArticle/{articleId}")
    public String removeSubByArticle(@PathVariable long articleId) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        long currentUserId = userService.getUserByUserName(name).getUserId();
        Subscription sub = service.getOneSubscription(articleId, currentUserId);
        service.removeSub(sub.getId());
        return "redirect:/subs/" + currentUserId;
    }
}

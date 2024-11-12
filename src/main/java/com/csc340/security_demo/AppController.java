package com.csc340.security_demo;

import com.csc340.security_demo.chat.ChatMessage;
import com.csc340.security_demo.chat.ChatMessageRepository;
import com.csc340.security_demo.user.User;
import com.csc340.security_demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    ChatMessageRepository chatRepo;

    @GetMapping({"", "/", "/home", "app"})
    public String home() {
        return "redirect:/articles/all";
    }

    @GetMapping("/chat")
    public String chat(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userService.getUserByUserName(name);
        model.addAttribute("currentUser", currentUser);
        List<ChatMessage> previousMessages = chatRepo.findAll();
        model.addAttribute("previousMessages", previousMessages.subList(previousMessages.size() - 5, previousMessages.size()));

        return "chat";
    }


    @GetMapping("/error")
    public String showError() {
        return "error";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/403")
    public String _403() {
        return "403";
    }
}

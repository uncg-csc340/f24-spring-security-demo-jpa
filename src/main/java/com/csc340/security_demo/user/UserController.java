package com.csc340.security_demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ADMIN")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping({"", "/"})
    public String userMenu(@RequestParam(name = "continue", required = false) String cont) {
        return "user/menu";
    }

    @GetMapping("/users/all")
    public String getAllUsers(Model model,
                              @RequestParam(name = "continue", required = false) String cont) {
        model.addAttribute("userList", service.getAllUsers());
        return "user/user-list";
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable long id, Model model) {
        model.addAttribute("user", service.getUser(id));
        return "user/user-details";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUserLazy(@PathVariable long id, Model model) {
        service.deleteUser(id);
        return "redirect:/ADMIN/users/all";
    }


    @GetMapping("/users/createForm")
    public String newUserForm(Model model) {
        return "user/user-create";
    }


    @PostMapping("/users/new")
    public String createUser(@ModelAttribute("user") User user) {
        service.saveUser(user);
        return "redirect:/ADMIN/users/all";
    }


    @GetMapping("/users/update/{id}")
    public String updateUserForm(@PathVariable long id, Model model) {
        model.addAttribute("user", service.getUser(id));
        return "user/user-update";
    }

    @PostMapping("/users/update")
    public String updateUser(User user) {
        service.updateUser(user);
        return "redirect:/ADMIN/users/"+user.getUserId();
    }


}
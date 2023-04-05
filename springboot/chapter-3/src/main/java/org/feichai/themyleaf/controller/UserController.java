package org.feichai.themyleaf.controller;

import jakarta.validation.Valid;
import org.feichai.themyleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("title", "i miss you");
        return "user/addUser";
    }

    @PostMapping("/addUser")
    @ResponseBody
    public String createUser(@Valid @RequestBody User user) {
        return user.toString();
    }
}

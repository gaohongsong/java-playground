package org.feichai.themyleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("title", "i miss you");
        return "user/addUser";
    }

}

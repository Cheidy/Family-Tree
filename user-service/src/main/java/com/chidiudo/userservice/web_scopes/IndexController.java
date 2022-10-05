package com.chidiudo.userservice.web_scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private RandomNumberService numberService;

    @GetMapping("/home")
    public String indexAction(Model model) {
        model.addAttribute("message", numberService);
        return "index.html";
    }
}

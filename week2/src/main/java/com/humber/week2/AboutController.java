package com.humber.week2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("name", "Jason Zhang");
        model.addAttribute("email", "n01677466@humber.ca");
        model.addAttribute("hobbits","basketball");
        return "about";
    }
}

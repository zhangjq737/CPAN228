package com.humber.week2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// this annotation means the class will be acting as a Spring bean, which is responsible for Http requests. it is part of spring MVC structure, standing for C.
@Controller
public class HomeController {
    // there are GetMapping and PostMapping annotations. we can use more generic RequestMapping, but more specific is better.
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello World ~");
        // this view name is resolved by Thymeleaf. and View stands for V in MVC structure.
        return "home";
    }
}

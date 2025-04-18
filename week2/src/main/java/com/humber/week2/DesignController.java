package com.humber.week2;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.humber.week2.model.Anime;
import com.humber.week2.model.CharacterPool;
import com.humber.week2.model.Fighter;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@RequestMapping("/design")
@SessionAttributes("characterPool")
public class DesignController {

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("characterPool", new CharacterPool());
        log.info("Added characterPool to model");
    }

    @ModelAttribute
    public void addAnimes(Model model) {
        var animes = List.of(Anime.values()).stream().map(Anime::name).collect(Collectors.toList());
        model.addAttribute("animes", animes);
        log.info("Added animes to model");
    }

    @ModelAttribute(name = "fighter")
    public Fighter fighter() {
        //return new Fighter(null, 0, 0, 0, null);
        return new Fighter(null,0,0,0.0000001,null);
    }

    @GetMapping
    public String showDesign() {
        return "design";
    }
}

package com.CPAN228.test1.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.CPAN228.test1.data.jdbc.JdbcFighterRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.CPAN228.test1.model.Anime;
import com.CPAN228.test1.model.CharacterPool;
import com.CPAN228.test1.model.Fighter;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@RequestMapping("/design")
@SessionAttributes("characterPool")
public class DesignController {
    private final JdbcFighterRepository fighterRepository = new JdbcFighterRepository(new JdbcTemplate());

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
        return new Fighter();
    }

    @PostMapping
    public String processDesign(@ModelAttribute("fighter") Fighter fighter) {
        // Process the submitted fighter data (e.g., validation, saving to a database)
        // Redirect or return the appropriate view
        fighterRepository.save(fighter);
        return "result";
    }

    @GetMapping
    public String showDesign() {
        return "design";
    }
}

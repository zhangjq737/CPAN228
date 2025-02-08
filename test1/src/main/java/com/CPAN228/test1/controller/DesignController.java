package com.CPAN228.test1.controller;

import java.util.List;
import java.util.Optional;
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
    private final JdbcFighterRepository fighterRepository;

    public DesignController(JdbcFighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

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
        return new Fighter();
    }

    @PostMapping
    public String processDesign(@ModelAttribute("fighter") Fighter fighter) {
        fighterRepository.save(fighter);
        return "result";
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("fighters", fighterRepository.findAll());
        return "all";
    }

    @GetMapping("/getById/{id}")
    public String getById(@PathVariable("id") long id, Model model) {
        // Retrieve the fighter by ID using the repository
        Optional<Fighter> fighterOptional = fighterRepository.findById(id);
        if (fighterOptional.isPresent()) {
            // Add the found fighter to the model
            model.addAttribute("fighter", fighterOptional.get());
            // Return a view that displays details for a single fighter
            return "fighterDetail";
        } else {
            // Handle the case where no fighter is found (e.g., return an error view)
            model.addAttribute("errorMessage", "Fighter not found");
            return "error";
        }
    }

    @GetMapping
    public String showDesign() {
        return "design";
    }
}

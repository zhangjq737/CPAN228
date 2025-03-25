package com.CPAN228.test1.controller;

import com.CPAN228.test1.model.Trivia;
import com.CPAN228.test1.service.TriviaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TriviaController {
    private final TriviaService triviaService;

    public TriviaController(TriviaService triviaService) {
        this.triviaService = triviaService;
    }

    @GetMapping("/trivia")
    public Mono<Trivia> getRandomTrivia() {
        return triviaService.getRandomTrivia();
    }

    // Optional: If you want to log or process all fields
    @GetMapping("/trivia-details")
    public Mono<String> getTriviaDetails() {
        return triviaService.getRandomTrivia()
                .map(trivia -> String.format(
                        "Trivia Details:\n" +
                                "ID: %s\n" +
                                "Text: %s\n" +
                                "Source: %s\n" +
                                "Source URL: %s\n" +
                                "Language: %s\n" +
                                "Permalink: %s",
                        trivia.getId(),
                        trivia.getText(),
                        trivia.getSource(),
                        trivia.getSourceUrl(),
                        trivia.getLanguage(),
                        trivia.getPermalink()
                ));
    }
}
package com.CPAN228.test1.service;

import com.CPAN228.test1.model.Trivia;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TriviaService {
    private static final String TRIVIA_API_URL = "https://uselessfacts.jsph.pl/api/v2/facts/random?language=en";

    private final WebClient webClient;

    public TriviaService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl(TRIVIA_API_URL)
                .build();
    }

    public Mono<Trivia> getRandomTrivia() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("language", "en").build())
                .retrieve()
                .bodyToMono(Trivia.class)
                .doOnError(error -> {
                    System.err.println("Error fetching trivia: " + error.getMessage());
                });
    }
}
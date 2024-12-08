package com.myke.studios;

import com.myke.studios.application.controller.PokemonController;
import com.myke.studios.domain.service.PokemonService;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 */
public class Initializer {
    public static void main(String[] args) {
      RestTemplate restTemplate = new RestTemplate();
      PokemonService pokemonService = new PokemonService(restTemplate);
      pokemonService.getPokemonFromTo(1,2);

    }
}

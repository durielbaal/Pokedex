package com.myke.studios.application.controller;

import com.myke.studios.domain.service.PokemonService;
import com.myke.studios.infraestructure.output.PokemonOutputPort;
import com.myke.studios.shared.Constants;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@Data
@RequiredArgsConstructor
@RestController(Constants.POKEMON_OWN_URL)
public class PokemonController  {

  private final PokemonOutputPort pokemonOutputPort;

  @GetMapping(path = Constants.HOENN_REGION)
  public ResponseEntity<String> getPokemonFromTo() {
    ResponseEntity<String> responseEntity = ResponseEntity.ok("Pokemon of Hoenn were stored correctly");
    try{
      pokemonOutputPort.getPokemonFromTo(252,386);
    } catch (Exception e) {
        responseEntity = ResponseEntity.badRequest().body("Something was wrong during storage of Hoenn Pokemon");
    }
    return responseEntity;
  }
}

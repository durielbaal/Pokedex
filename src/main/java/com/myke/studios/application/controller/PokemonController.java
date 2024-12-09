package com.myke.studios.application.controller;

import com.myke.studios.domain.entity.Pokemon;
import com.myke.studios.domain.service.PokemonService;
import com.myke.studios.infraestructure.output.PokemonOutputPort;
import com.myke.studios.shared.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@Data
@RequiredArgsConstructor
@RestController(Constants.POKEMON_OWN_BASE)
public class PokemonController  {

  private final PokemonOutputPort pokemonOutputPort;

  @GetMapping(path = Constants.HOENN_SAVE_REGION)
  public ResponseEntity<String> getPokemonFromTo() {
    ResponseEntity<String> responseEntity = ResponseEntity.ok("Pokemon of Hoenn were stored correctly");
    try{
      pokemonOutputPort.storePokemonFromTo(252,386);
    } catch (Exception e) {
        responseEntity = ResponseEntity.badRequest().body("Something was wrong during storage of Hoenn Pokemon");
    }
    return responseEntity;
  }
  @GetMapping(path = Constants.GET_HOENN_POKEDEX)
  public ResponseEntity<Map<String,List<Pokemon>>> getHoennPokedex(){
    Map<String, List<Pokemon>> map = new HashMap<>();
    try{
      List<Pokemon> hoennPokedex = pokemonOutputPort.getAllPokemon();
      map.put("Pokedex of Hoenn completed", hoennPokedex);
    } catch (Exception e) {
      List<Pokemon> hoennPokedex = new ArrayList<>();
      map.put("Something was wrong...", hoennPokedex);
      return ResponseEntity.badRequest().body(map);
    }
    return ResponseEntity.ok(map);
  }

  @GetMapping(Constants.TEST)
  public ResponseEntity<String> testing() {
    return  ResponseEntity.ok("This is a test, and it works :)");
  }


}

package com.myke.studios.infraestructure.output;

import com.myke.studios.domain.entity.Pokemon;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface PokemonOutputPort {
  public void storePokemonFromTo(int begin,int end);
  public List<Pokemon> getAllPokemon();
}

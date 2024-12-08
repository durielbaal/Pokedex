package com.myke.studios.domain.service;

import com.myke.studios.domain.entity.Pokemon;
import com.myke.studios.infraestructure.dto.DetailsDto;
import com.myke.studios.infraestructure.dto.FlavorTextEntriesDto;
import com.myke.studios.infraestructure.dto.ParametersDto;
import com.myke.studios.infraestructure.output.PokemonOutputPort;
import com.myke.studios.shared.Constants;
import com.myke.studios.shared.UrlMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.client.RestTemplate;

@Data
@AllArgsConstructor
public class PokemonService implements PokemonOutputPort {

  private final RestTemplate restTemplate;

  @Override
  public void getPokemonFromTo(int begin, int end) {
    for(int i = begin; i <= end; i++) {
      ParametersDto parametersDto = getParameter(i);
      DetailsDto detailsDto =getDetails(i);
      Optional<FlavorTextEntriesDto> optionalFTE = detailsDto.getFlavorTextEntries().stream()
          .filter(entry ->"en".equals(entry.getLanguage().getName()))
          .findFirst();
      FlavorTextEntriesDto flavorTextEntriesDto = optionalFTE.orElse(null);
      Pokemon pokemon = getPokemon(flavorTextEntriesDto, parametersDto, detailsDto);
      System.out.println("Nº " + i + ": " + pokemon.toString());

    }
  }

  private Pokemon getPokemon(FlavorTextEntriesDto flavorTextEntriesDto,
      ParametersDto parametersDto,
      DetailsDto detailsDto) {
    String description =  flavorTextEntriesDto != null ?
        flavorTextEntriesDto.getFlavorText() : "Not found an english entry";
    return new Pokemon(parametersDto.getId(),
        parametersDto.getName(),
        parametersDto.getHeight(),
        parametersDto.getWeight(),
        description,
        detailsDto.getGenus(),
        detailsDto.getHabitat().getName(),
        parametersDto.getTypes());

  }

  private ParametersDto getParameter(int id){
    String parametersEndPoint = Constants.POKEMON_BASE_URL + Constants.POKEMON_PARAMETERS;
    Map<String, String> parametersAttr = new HashMap<>();
    parametersAttr.put("{id}",String.valueOf(id));
    String url = UrlMapper.convertUrl(parametersAttr,parametersEndPoint);
    return restTemplate.getForObject(url, ParametersDto.class);
  }

  private DetailsDto getDetails(int id){
    String detailsEndPoint = Constants.POKEMON_BASE_URL + Constants.POKEMON_DETAILS;
    Map<String, String> detailsAttr = new HashMap<>();
    detailsAttr.put("{id}",String.valueOf(id));
    String url = UrlMapper.convertUrl(detailsAttr,detailsEndPoint);
    return restTemplate.getForObject(url, DetailsDto.class);
  }
}

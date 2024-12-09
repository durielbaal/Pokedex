package com.myke.studios.domain.service;

import com.myke.studios.domain.entity.Pokemon;
import com.myke.studios.infraestructure.dto.DetailsDto;
import com.myke.studios.infraestructure.dto.FlavorTextEntriesDto;
import com.myke.studios.infraestructure.dto.GeneraDto;
import com.myke.studios.infraestructure.dto.ParametersDto;
import com.myke.studios.infraestructure.output.PokemonOutputPort;
import com.myke.studios.infraestructure.repository.PokemonRepository;
import com.myke.studios.shared.Constants;
import com.myke.studios.shared.UrlMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@Data
@RequiredArgsConstructor

public class PokemonService implements PokemonOutputPort {

  private final RestTemplate restTemplate;
  private final PokemonRepository pokemonRepository;

  @Override
  public void storePokemonFromTo(int begin, int end) {
    for(int i = begin; i <= end; i++) {
      ParametersDto parametersDto = getParameter(i);
      DetailsDto detailsDto =getDetails(i);
      Optional<FlavorTextEntriesDto> optionalFTE = detailsDto.getFlavorTextEntries().stream()
          .filter(entry ->"en".equals(entry.getLanguage().getName()))
          .findFirst();
      FlavorTextEntriesDto flavorTextEntriesDto = optionalFTE.orElse(null);
      Pokemon pokemon = getPokemon(flavorTextEntriesDto, parametersDto, detailsDto);
      pokemonRepository.save(pokemon);
    }
  }

  @Override
  public List<Pokemon> getAllPokemon() {
    return pokemonRepository.findAll();
  }

  private Pokemon getPokemon(FlavorTextEntriesDto flavorTextEntriesDto,
      ParametersDto parametersDto,
      DetailsDto detailsDto) {
    String description =  flavorTextEntriesDto != null ?
        flavorTextEntriesDto.getFlavorText() : "Not found an english entry";
    Optional<GeneraDto> opGeneraDto = detailsDto.getGenera().stream()
        .filter(entry ->"en".equals(entry.getLanguage().getName()))
        .findFirst();
    String specie = opGeneraDto.isPresent() ?
        opGeneraDto.get().getGenus() : "Not found an english entry";
    return new Pokemon(parametersDto.getId(),
        parametersDto.getName(),
        parametersDto.getHeight(),
        parametersDto.getWeight(),
        description,
        specie,
        detailsDto.getHabitat().getName(),
        parametersDto.getTypes(),
        parametersDto.getSprites()
        );
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

package com.myke.studios.domain.entity;

import com.myke.studios.infraestructure.dto.TypeDto;
import com.myke.studios.infraestructure.dto.TypesDto;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Pokemon {
  @Id
  private int id;
  private String name;
  private double height;
  private double weight;
  private String description;
  private String specie;
  private String habitat;
  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "types", joinColumns = @JoinColumn(name = "pokedexNumber"))
  private List<String> types;

  public Pokemon (int id, String name, double height, double weight, String description,
      String specie, String habitat, List<TypesDto> types) {
    this.id = id;
    this.name = name;
    this.height = height / 10;
    this.weight = weight / 100;
    this.description = description;
    this.specie = specie;
    this.habitat = habitat;
    this.types = getTypesString(types);
  }

  private List<String> getTypesString(List<TypesDto> typeDtoList){
    return typeDtoList.stream()
        .map(typeDto -> typeDto.getType().getName())
        .toList();
  }

}

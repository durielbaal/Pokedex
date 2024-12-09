package com.myke.studios.infraestructure.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParametersDto {
  private int id;
  private String name;
  private double height;
  private double weight;
  private List<TypesDto> types;
  private SpritesDto sprites;
}

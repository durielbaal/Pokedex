package com.myke.studios.infraestructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneraDto {
  private String genus;
  private LanguageDto language;

}

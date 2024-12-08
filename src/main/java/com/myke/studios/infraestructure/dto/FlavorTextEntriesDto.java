package com.myke.studios.infraestructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlavorTextEntriesDto {
  @JsonProperty("flavor_text")
  private String flavorText;
  private LanguageDto language;
}

package com.myke.studios.infraestructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailsDto {
  private HabitatDto habitat;
  @JsonProperty("flavor_text_entries")
  private List<FlavorTextEntriesDto> flavorTextEntries;
  private List<GeneraDto> genera;
}

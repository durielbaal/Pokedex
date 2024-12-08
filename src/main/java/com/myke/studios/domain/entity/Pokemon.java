package com.myke.studios.domain.entity;

import com.myke.studios.infraestructure.dto.TypeDto;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
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

  @ElementCollection
  private List<TypeDto> types;
}

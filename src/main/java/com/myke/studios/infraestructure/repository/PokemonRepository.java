package com.myke.studios.infraestructure.repository;

import com.myke.studios.domain.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

}

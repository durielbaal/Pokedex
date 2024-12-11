package com.myke.studios;

import com.myke.studios.application.controller.PokemonController;
import com.myke.studios.domain.entity.Pokemon;
import com.myke.studios.domain.service.PokemonService;
import com.myke.studios.infraestructure.repository.PokemonRepository;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 */
public class Initializer {
    public static void main(String[] args) {
      RestTemplate restTemplate = new RestTemplate();
      PokemonRepository pokemonRepository = new PokemonRepository() {
        @Override
        public void flush() {

        }

        @Override
        public <S extends Pokemon> S saveAndFlush(S entity) {
          return null;
        }

        @Override
        public <S extends Pokemon> List<S> saveAllAndFlush(Iterable<S> entities) {
          return List.of();
        }

        @Override
        public void deleteAllInBatch(Iterable<Pokemon> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Integer> integers) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Pokemon getOne(Integer integer) {
          return null;
        }

        @Override
        public Pokemon getById(Integer integer) {
          return null;
        }

        @Override
        public Pokemon getReferenceById(Integer integer) {
          return null;
        }

        @Override
        public <S extends Pokemon> List<S> findAll(Example<S> example) {
          return List.of();
        }

        @Override
        public <S extends Pokemon> List<S> findAll(Example<S> example, Sort sort) {
          return List.of();
        }

        @Override
        public <S extends Pokemon> List<S> saveAll(Iterable<S> entities) {
          return List.of();
        }

        @Override
        public List<Pokemon> findAll() {
          return List.of();
        }

        @Override
        public List<Pokemon> findAllById(Iterable<Integer> integers) {
          return List.of();
        }

        @Override
        public <S extends Pokemon> S save(S entity) {
          return null;
        }

        @Override
        public Optional<Pokemon> findById(Integer integer) {
          return Optional.empty();
        }

        @Override
        public boolean existsById(Integer integer) {
          return false;
        }

        @Override
        public long count() {
          return 0;
        }

        @Override
        public void deleteById(Integer integer) {

        }

        @Override
        public void delete(Pokemon entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Integer> integers) {

        }

        @Override
        public void deleteAll(Iterable<? extends Pokemon> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<Pokemon> findAll(Sort sort) {
          return List.of();
        }

        @Override
        public Page<Pokemon> findAll(Pageable pageable) {
          return null;
        }

        @Override
        public <S extends Pokemon> Optional<S> findOne(Example<S> example) {
          return Optional.empty();
        }

        @Override
        public <S extends Pokemon> Page<S> findAll(Example<S> example, Pageable pageable) {
          return null;
        }

        @Override
        public <S extends Pokemon> long count(Example<S> example) {
          return 0;
        }

        @Override
        public <S extends Pokemon> boolean exists(Example<S> example) {
          return false;
        }

        @Override
        public <S extends Pokemon, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
          return null;
        }
      };
      PokemonService pokemonService = new PokemonService(restTemplate,pokemonRepository);
      //pokemonService.storePokemonFromTo(149,151);
    }
}

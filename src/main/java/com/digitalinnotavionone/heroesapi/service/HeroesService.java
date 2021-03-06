package com.digitalinnotavionone.heroesapi.service;

import com.digitalinnotavionone.heroesapi.document.Heroes;
import com.digitalinnotavionone.heroesapi.repository.HeroesRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesService {
    private final HeroesRepository heroesRepository;

    public HeroesService(HeroesRepository heroesRepository){
        this.heroesRepository = heroesRepository;
    }

    public Flux<Heroes> findAll(){
        return Flux.fromIterable(this.heroesRepository.findAll());
    }

    public Mono<Heroes> findByIdHero(String id){
        return Mono.justOrEmpty(this.heroesRepository.findById(id));
    }

    public Mono<Heroes> save(Heroes hero){
        return Mono.justOrEmpty(this.heroesRepository.save(hero));
    }

    public Mono<Boolean> deleteByIdHero(String id){
        this.heroesRepository.deleteById(id);
        return Mono.just(true);
    }
}

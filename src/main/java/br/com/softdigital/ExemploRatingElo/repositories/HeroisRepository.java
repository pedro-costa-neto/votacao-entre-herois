package br.com.softdigital.ExemploRatingElo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.softdigital.ExemploRatingElo.domains.HeroisDomain;

public interface HeroisRepository extends MongoRepository<HeroisDomain, String> {
    @Query("{ sample: { size: 1 } }")
    HeroisDomain findRandom();
}
package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;

import br.ufes.sead.sgcbackend.models.Bond;

public interface BondRepository extends CrudRepository<Bond, Integer> {
    
}
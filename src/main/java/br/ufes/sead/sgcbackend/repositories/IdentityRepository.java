package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;

import br.ufes.sead.sgcbackend.models.Identity;

public interface IdentityRepository extends CrudRepository<Identity, Integer> {
    
}

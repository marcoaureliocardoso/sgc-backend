package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;

import br.ufes.sead.sgcbackend.models.Impediment;

public interface ImpedimentRepository extends CrudRepository<Impediment, Integer>{
    
}

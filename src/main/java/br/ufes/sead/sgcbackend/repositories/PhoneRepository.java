package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;

import br.ufes.sead.sgcbackend.models.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Integer>{
    
}

package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;

import br.ufes.sead.sgcbackend.models.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {
    
}

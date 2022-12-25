package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.models.Address;

public interface AddressRepository
        extends CrudRepository<Address, Integer>, PagingAndSortingRepository<Address, Integer> {

}

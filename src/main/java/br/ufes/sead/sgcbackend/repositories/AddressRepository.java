package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Long>, PagingAndSortingRepository<Address, Long> {

}

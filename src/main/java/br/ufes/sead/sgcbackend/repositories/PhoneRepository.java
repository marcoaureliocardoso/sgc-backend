package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Long>, PagingAndSortingRepository<Phone, Long> {

}

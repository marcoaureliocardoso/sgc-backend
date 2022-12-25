package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.models.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Integer>, PagingAndSortingRepository<Phone, Integer> {

}

package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.Bond;

public interface BondRepository extends CrudRepository<Bond, Long>, PagingAndSortingRepository<Bond, Long> {

}

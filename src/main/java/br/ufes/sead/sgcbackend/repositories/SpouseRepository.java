package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.Spouse;

public interface SpouseRepository extends CrudRepository<Spouse, Long>, PagingAndSortingRepository<Spouse, Long> {

}

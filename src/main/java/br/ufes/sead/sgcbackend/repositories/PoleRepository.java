package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.Pole;

public interface PoleRepository extends CrudRepository<Pole, Long>, PagingAndSortingRepository<Pole, Long> {

}

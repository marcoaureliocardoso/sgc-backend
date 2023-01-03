package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.Responsibility;

public interface ResponsibilityRepository
        extends CrudRepository<Responsibility, Long>, PagingAndSortingRepository<Responsibility, Long> {

}

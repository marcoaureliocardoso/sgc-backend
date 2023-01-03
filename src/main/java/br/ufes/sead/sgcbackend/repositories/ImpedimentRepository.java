package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.Impediment;

public interface ImpedimentRepository
                extends CrudRepository<Impediment, Long>, PagingAndSortingRepository<Impediment, Long> {

}

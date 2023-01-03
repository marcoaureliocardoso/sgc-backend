package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.Qualification;

public interface QualificationRepository
        extends CrudRepository<Qualification, Long>, PagingAndSortingRepository<Qualification, Long> {

}

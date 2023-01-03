package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.PersonalDetail;

public interface PersonalDetailRepository
        extends CrudRepository<PersonalDetail, Long>, PagingAndSortingRepository<PersonalDetail, Long> {

}

package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.models.UserType;

public interface UserTypeRepository
        extends CrudRepository<UserType, Integer>, PagingAndSortingRepository<UserType, Integer> {

}

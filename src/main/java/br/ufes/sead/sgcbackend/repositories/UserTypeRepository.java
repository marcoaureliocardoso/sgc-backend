package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.UserType;

public interface UserTypeRepository
                extends CrudRepository<UserType, Long>, PagingAndSortingRepository<UserType, Long> {

}

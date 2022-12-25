package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.models.Role;

public interface RoleRepository extends CrudRepository<Role, Integer>, PagingAndSortingRepository<Role, Integer> {

}

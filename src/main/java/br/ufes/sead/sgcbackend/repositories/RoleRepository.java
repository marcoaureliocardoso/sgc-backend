package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long>, PagingAndSortingRepository<Role, Long> {

}

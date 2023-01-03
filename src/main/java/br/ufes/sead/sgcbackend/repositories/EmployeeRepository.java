package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.Employee;

public interface EmployeeRepository
                extends CrudRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {

}

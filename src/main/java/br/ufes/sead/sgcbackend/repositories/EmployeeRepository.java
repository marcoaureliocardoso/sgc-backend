package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.models.Employee;

public interface EmployeeRepository
        extends CrudRepository<Employee, Integer>, PagingAndSortingRepository<Employee, Integer> {

}

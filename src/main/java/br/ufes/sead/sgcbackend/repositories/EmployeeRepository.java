package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;

import br.ufes.sead.sgcbackend.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    
}

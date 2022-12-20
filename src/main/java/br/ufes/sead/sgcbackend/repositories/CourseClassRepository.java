package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;

import br.ufes.sead.sgcbackend.models.CourseClass;

public interface CourseClassRepository extends CrudRepository<CourseClass, Integer>{
    
}

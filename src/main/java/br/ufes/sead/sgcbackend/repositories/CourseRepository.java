package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;

import br.ufes.sead.sgcbackend.models.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>{
    
}

package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.Course;

public interface CourseRepository extends CrudRepository<Course, Long>, PagingAndSortingRepository<Course, Long> {

}

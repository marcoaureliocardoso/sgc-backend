package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.models.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>, PagingAndSortingRepository<Course, Integer> {

}

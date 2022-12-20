package br.ufes.sead.sgcbackend.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.ufes.sead.sgcbackend.models.CourseClass;
import br.ufes.sead.sgcbackend.repositories.CourseClassRepository;

@RestController
@RequestMapping(path = "/api/v1/courseclasses")
public class CourseClassController {

    @Autowired
    private CourseClassRepository courseClassRepository;

    @GetMapping
    public Iterable<CourseClass> index() {
        return courseClassRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public CourseClass show(@PathVariable Integer id) {
        Optional<CourseClass> courseClass = courseClassRepository.findById(id);
        if (courseClass.isPresent()) {
            return courseClass.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CourseClass not found");
    }

}

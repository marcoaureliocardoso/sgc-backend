package br.ufes.sead.sgcbackend.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.ufes.sead.sgcbackend.models.CourseClass;
import br.ufes.sead.sgcbackend.repositories.CourseClassRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/courseclasses")
public class CourseClassController {

    @Autowired
    private CourseClassRepository courseClassRepository;

    @GetMapping
    public Iterable<CourseClass> index() {
        return courseClassRepository.findAll();
    }

    @PostMapping
    public @ResponseBody CourseClass store(@Valid @RequestBody CourseClass courseClass) {
        courseClassRepository.save(courseClass);
        return courseClass;
    }

    @GetMapping(path = "/{id}")
    public CourseClass show(@PathVariable Integer id) {
        Optional<CourseClass> courseClass = courseClassRepository.findById(id);
        if (courseClass.isPresent()) {
            return courseClass.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CourseClass not found");
    }

    @PutMapping(path = "/{id}")
    public CourseClass update(@PathVariable Integer id, @Valid @RequestBody CourseClass courseClass) {
        if (!courseClassRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CourseClass not found");
        }
        return courseClassRepository.save(courseClass);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Integer id) {
        if (!courseClassRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CourseClass not found");
        }
        courseClassRepository.deleteById(id);
    }

}

package br.ufes.sead.sgcbackend.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.ufes.sead.sgcbackend.entities.Course;
import br.ufes.sead.sgcbackend.repositories.CourseRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/courses")
public class CourseResource {

    private static final String COURSE_NOT_FOUND = "Course not found";
    
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public Iterable<Course> list(
            @RequestParam(name = "paginated", defaultValue = "true") String paginated,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "sortBy", defaultValue = "name") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {
        if (!paginated.equals("false")) {
            String sortKey = (Course.getSortKeysSet().contains(sortBy)) ? sortBy : "name";
            Direction direction = (sortDirection.equals("asc")) ? Direction.ASC : Direction.DESC;
            Pageable pageable = PageRequest.of(page, 10, Sort.by(direction, sortKey));

            return courseRepository.findAll(pageable);
        }

        return courseRepository.findAll();
    }

    @PostMapping
    public Course create(@Valid @RequestBody Course course) {
        courseRepository.save(course);
        return course;
    }

    @GetMapping(path = "/{id}")
    public Course read(@PathVariable Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return course.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, COURSE_NOT_FOUND);
    }

    @PutMapping(path = "/{id}")
    public Course update(@PathVariable Long id, @Valid @RequestBody Course course) {
        if (!courseRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, COURSE_NOT_FOUND);
        }
        return courseRepository.save(course);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Long id) {
        if (!courseRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, COURSE_NOT_FOUND);
        }
        courseRepository.deleteById(id);
    }

}

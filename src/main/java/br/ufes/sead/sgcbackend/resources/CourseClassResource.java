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

import br.ufes.sead.sgcbackend.entities.CourseClass;
import br.ufes.sead.sgcbackend.repositories.CourseClassRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/courseclasses")
public class CourseClassResource {

    private static final String COURSE_CLASS_NOT_FOUND = "CourseClass not found";
    @Autowired
    private CourseClassRepository courseClassRepository;

    @GetMapping
    public Iterable<CourseClass> list(
            @RequestParam(name = "paginated", defaultValue = "true") String paginated,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "sortBy", defaultValue = "name") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {
        if (!paginated.equals("false")) {
            String sortKey = (CourseClass.getSortKeysSet().contains(sortBy)) ? sortBy : "name";
            Direction direction = (sortDirection.equals("asc")) ? Direction.ASC : Direction.DESC;
            Pageable pageable = PageRequest.of(page, 10, Sort.by(direction, sortKey));

            return courseClassRepository.findAll(pageable);
        }

        return courseClassRepository.findAll();
    }

    @PostMapping
    public CourseClass create(@Valid @RequestBody CourseClass courseClass) {
        courseClassRepository.save(courseClass);
        return courseClass;
    }

    @GetMapping(path = "/{id}")
    public CourseClass read(@PathVariable Long id) {
        Optional<CourseClass> courseClass = courseClassRepository.findById(id);
        if (courseClass.isPresent()) {
            return courseClass.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, COURSE_CLASS_NOT_FOUND);
    }

    @PutMapping(path = "/{id}")
    public CourseClass update(@PathVariable Long id, @Valid @RequestBody CourseClass courseClass) {
        if (!courseClassRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, COURSE_CLASS_NOT_FOUND);
        }
        return courseClassRepository.save(courseClass);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Long id) {
        if (!courseClassRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, COURSE_CLASS_NOT_FOUND);
        }
        courseClassRepository.deleteById(id);
    }

}

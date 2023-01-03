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

import br.ufes.sead.sgcbackend.entities.Responsibility;
import br.ufes.sead.sgcbackend.repositories.ResponsibilityRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/responsibilities")
public class ResponsibilityResource {
    
    private static final String RESPONSIBILITY_NOT_FOUND = "Responsibility not found";

    @Autowired
    private ResponsibilityRepository responsibilityRepository;

    @GetMapping
    public Iterable<Responsibility> list(
            @RequestParam(name = "paginated", defaultValue = "true") String paginated,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {
        if (!paginated.equals("false")) {
            String sortKey = (Responsibility.getSortKeysSet().contains(sortBy)) ? sortBy : "id";
            Direction direction = (sortDirection.equals("asc")) ? Direction.ASC : Direction.DESC;
            Pageable pageable = PageRequest.of(page, 10, Sort.by(direction, sortKey));

            return responsibilityRepository.findAll(pageable);
        }

        return responsibilityRepository.findAll();
    }

    @PostMapping
    public Responsibility create(@Valid @RequestBody Responsibility responsibility) {
        responsibilityRepository.save(responsibility);
        return responsibility;
    }

    @GetMapping(path = "/{id}")
    public Responsibility read(@PathVariable Long id) {
        Optional<Responsibility> responsibility = responsibilityRepository.findById(id);
        if (responsibility.isPresent()) {
            return responsibility.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, RESPONSIBILITY_NOT_FOUND);
    }

    @PutMapping(path = "/{id}")
    public Responsibility update(@PathVariable Long id, @Valid @RequestBody Responsibility responsibility) {
        if (!responsibilityRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, RESPONSIBILITY_NOT_FOUND);
        }
        return responsibilityRepository.save(responsibility);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        if (!responsibilityRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, RESPONSIBILITY_NOT_FOUND);
        }
        responsibilityRepository.deleteById(id);
    }

}

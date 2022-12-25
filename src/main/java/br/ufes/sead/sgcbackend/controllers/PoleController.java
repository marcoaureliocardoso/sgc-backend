package br.ufes.sead.sgcbackend.controllers;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.ufes.sead.sgcbackend.models.Pole;
import br.ufes.sead.sgcbackend.repositories.PoleRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/poles")
public class PoleController {

    @Autowired
    private PoleRepository poleRepository;

    @GetMapping
    public Iterable<Pole> list(
            @RequestParam(name = "paginated", defaultValue = "true") String paginated,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "sortBy", defaultValue = "name") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {
        if (!paginated.equals("false")) {
            String sortKey = (Pole.getSortKeysSet().contains(sortBy)) ? sortBy : "name";
            Direction direction = (sortDirection.equals("asc")) ? Direction.ASC : Direction.DESC;
            Pageable pageable = PageRequest.of(page, 10, Sort.by(direction, sortKey));

            return poleRepository.findAll(pageable);
        }

        return poleRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Pole create(@Valid @RequestBody Pole pole) {
        poleRepository.save(pole);
        return pole;
    }

    @GetMapping(path = "/{id}")
    public Pole read(@PathVariable Integer id) {
        Optional<Pole> pole = poleRepository.findById(id);
        if (pole.isPresent()) {
            return pole.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pole not found");
    }

    @PutMapping(path = "/{id}")
    public Pole update(@PathVariable Integer id, @Valid @RequestBody Pole pole) {
        if (!poleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pole not found");
        }
        return poleRepository.save(pole);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Integer id) {
        if (!poleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pole not found");
        }
        poleRepository.deleteById(id);
    }

}

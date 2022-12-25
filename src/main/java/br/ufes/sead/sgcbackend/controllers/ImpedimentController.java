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

import br.ufes.sead.sgcbackend.models.Impediment;
import br.ufes.sead.sgcbackend.repositories.ImpedimentRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/impediments")
public class ImpedimentController {

    @Autowired
    private ImpedimentRepository impedimentRepository;

    @GetMapping
    public Iterable<Impediment> list(
            @RequestParam(name = "paginated", defaultValue = "true") String paginated,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "sortBy", defaultValue = "createdAt") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {
        if (!paginated.equals("false")) {
            String sortKey = (Impediment.getSortKeysSet().contains(sortBy)) ? sortBy : "createdAt";
            Direction direction = (sortDirection.equals("asc")) ? Direction.ASC : Direction.DESC;
            Pageable pageable = PageRequest.of(page, 10, Sort.by(direction, sortKey));

            return impedimentRepository.findAll(pageable);
        }

        return impedimentRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Impediment create(@Valid @RequestBody Impediment impediment) {
        impedimentRepository.save(impediment);
        return impediment;
    }

    @GetMapping(path = "/{id}")
    public Impediment read(@PathVariable Integer id) {
        Optional<Impediment> impediment = impedimentRepository.findById(id);
        if (impediment.isPresent()) {
            return impediment.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impediment not found");
    }

    @PutMapping(path = "/{id}")
    public Impediment update(@PathVariable Integer id, @Valid @RequestBody Impediment impediment) {
        if (!impedimentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impediment not found");
        }
        return impedimentRepository.save(impediment);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Integer id) {
        if (!impedimentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impediment not found");
        }
        impedimentRepository.deleteById(id);
    }

}

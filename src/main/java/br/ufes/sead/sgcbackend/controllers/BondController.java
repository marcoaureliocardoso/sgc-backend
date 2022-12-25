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

import br.ufes.sead.sgcbackend.models.Bond;
import br.ufes.sead.sgcbackend.repositories.BondRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/bonds")
public class BondController {

    @Autowired
    private BondRepository bondRepository;

    @GetMapping
    public Iterable<Bond> list(
            @RequestParam(name = "paginated", defaultValue = "true") String paginated,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "sortBy", defaultValue = "hiringProcess") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {
        if (!paginated.equals("false")) {
            String sortKey = (Bond.getSortKeysSet().contains(sortBy)) ? sortBy : "hiringProcess";
            Direction direction = (sortDirection.equals("asc")) ? Direction.ASC : Direction.DESC;
            Pageable pageable = PageRequest.of(page, 10, Sort.by(direction, sortKey));

            return bondRepository.findAll(pageable);
        }

        return bondRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Bond create(@Valid @RequestBody Bond bond) {
        bondRepository.save(bond);
        return bond;
    }

    @GetMapping(path = "/{id}")
    public Bond read(@PathVariable Integer id) {
        Optional<Bond> bond = bondRepository.findById(id);
        if (bond.isPresent()) {
            return bond.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bond not found");
    }

    @PutMapping(path = "/{id}")
    public Bond update(@PathVariable Integer id, @Valid @RequestBody Bond bond) {
        if (!bondRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bond not found");
        }
        return bondRepository.save(bond);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Integer id) {
        if (!bondRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bond not found");
        }
        bondRepository.deleteById(id);
    }

}

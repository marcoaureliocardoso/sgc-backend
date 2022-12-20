package br.ufes.sead.sgcbackend.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.ufes.sead.sgcbackend.models.Bond;
import br.ufes.sead.sgcbackend.repositories.BondRepository;

@RestController
@RequestMapping(path = "/api/v1/bonds")
public class BondController {

    @Autowired
    private BondRepository bondRepository;

    @GetMapping
    public Iterable<Bond> index() {
        return bondRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Bond show(@PathVariable Integer id) {
        Optional<Bond> bond = bondRepository.findById(id);
        if (bond.isPresent()) {
            return bond.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bond not found");
    }

}

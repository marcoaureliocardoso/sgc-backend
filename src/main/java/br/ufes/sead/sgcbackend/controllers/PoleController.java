package br.ufes.sead.sgcbackend.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.ufes.sead.sgcbackend.models.Pole;
import br.ufes.sead.sgcbackend.repositories.PoleRepository;

@RestController
@RequestMapping(path = "/api/v1/poles")
public class PoleController {

    @Autowired
    private PoleRepository poleRepository;

    @GetMapping
    public Iterable<Pole> index() {
        return poleRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Pole show(@PathVariable Integer id) {
        Optional<Pole> pole = poleRepository.findById(id);
        if (pole.isPresent()) {
            return pole.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pole not found");
    }

}

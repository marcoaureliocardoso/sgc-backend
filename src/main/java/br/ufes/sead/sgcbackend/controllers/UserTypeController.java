package br.ufes.sead.sgcbackend.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.ufes.sead.sgcbackend.models.UserType;
import br.ufes.sead.sgcbackend.repositories.UserTypeRepository;

@RestController
@RequestMapping(path = "/api/v1/usertypes")
public class UserTypeController {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @GetMapping
    public Iterable<UserType> index() {
        return userTypeRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public UserType show(@PathVariable Integer id) {
        Optional<UserType> userType = userTypeRepository.findById(id);
        if (userType.isPresent()) {
            return userType.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UserType not found");
    }
}

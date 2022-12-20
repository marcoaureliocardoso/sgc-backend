package br.ufes.sead.sgcbackend.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.ufes.sead.sgcbackend.models.DocumentType;
import br.ufes.sead.sgcbackend.repositories.DocumentTypeRepository;

@RestController
@RequestMapping(path = "/api/v1/documenttypes")
public class DocumentTypeController {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @GetMapping
    public Iterable<DocumentType> index() {
        return documentTypeRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public DocumentType show(@PathVariable Integer id) {
        Optional<DocumentType> documentType = documentTypeRepository.findById(id);
        if (documentType.isPresent()) {
            return documentType.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DocumentType not found");
    }

}

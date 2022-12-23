package br.ufes.sead.sgcbackend.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.ufes.sead.sgcbackend.models.Document;
import br.ufes.sead.sgcbackend.repositories.DocumentRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/documents")
public class DocumentController {

    @Autowired
    private DocumentRepository documentRepository;

    @GetMapping
    public Iterable<Document> index() {
        return documentRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Document store(@Valid @RequestBody Document document) {
        documentRepository.save(document);
        return document;
    }

    @GetMapping(path = "/{id}")
    public Document show(@PathVariable Integer id) {
        Optional<Document> document = documentRepository.findById(id);
        if (document.isPresent()) {
            return document.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Document not found");
    }

    @PutMapping(path = "/{id}")
    public Document update(@PathVariable Integer id, @Valid @RequestBody Document document) {
        if (!documentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Document not found");
        }
        return documentRepository.save(document);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Integer id) {
        if (!documentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Document not found");
        }
        documentRepository.deleteById(id);
    }

}

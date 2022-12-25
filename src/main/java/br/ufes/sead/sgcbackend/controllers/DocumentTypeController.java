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

import br.ufes.sead.sgcbackend.models.DocumentType;
import br.ufes.sead.sgcbackend.repositories.DocumentTypeRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/documenttypes")
public class DocumentTypeController {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @GetMapping
    public Iterable<DocumentType> list(
            @RequestParam(name = "paginated", defaultValue = "true") String paginated,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "sortBy", defaultValue = "name") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {
        if (!paginated.equals("false")) {
            String sortKey = (DocumentType.getSortKeysSet().contains(sortBy)) ? sortBy : "name";
            Direction direction = (sortDirection.equals("asc")) ? Direction.ASC : Direction.DESC;
            Pageable pageable = PageRequest.of(page, 10, Sort.by(direction, sortKey));

            return documentTypeRepository.findAll(pageable);
        }

        return documentTypeRepository.findAll();
    }

    @PostMapping
    public @ResponseBody DocumentType create(@Valid @RequestBody DocumentType documentType) {
        documentTypeRepository.save(documentType);
        return documentType;
    }

    @GetMapping(path = "/{id}")
    public DocumentType read(@PathVariable Integer id) {
        Optional<DocumentType> documentType = documentTypeRepository.findById(id);
        if (documentType.isPresent()) {
            return documentType.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DocumentType not found");
    }

    @PutMapping(path = "/{id}")
    public DocumentType update(@PathVariable Integer id, @Valid @RequestBody DocumentType documentType) {
        if (!documentTypeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DocumentType not found");
        }
        return documentTypeRepository.save(documentType);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Integer id) {
        if (!documentTypeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DocumentType not found");
        }
        documentTypeRepository.deleteById(id);
    }

}

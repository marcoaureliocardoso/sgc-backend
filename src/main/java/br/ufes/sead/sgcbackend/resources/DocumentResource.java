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

import br.ufes.sead.sgcbackend.entities.Document;
import br.ufes.sead.sgcbackend.repositories.DocumentRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/documents")
public class DocumentResource {

    private static final String DOCUMENT_NOT_FOUND = "Document not found";
    @Autowired
    private DocumentRepository documentRepository;

    @GetMapping
    public Iterable<Document> list(
            @RequestParam(name = "paginated", defaultValue = "true") String paginated,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "sortBy", defaultValue = "fileName") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {
        if (!paginated.equals("false")) {
            String sortKey = (Document.getSortKeysSet().contains(sortBy)) ? sortBy : "fileName";
            Direction direction = (sortDirection.equals("asc")) ? Direction.ASC : Direction.DESC;
            Pageable pageable = PageRequest.of(page, 10, Sort.by(direction, sortKey));

            return documentRepository.findAll(pageable);
        }

        return documentRepository.findAll();
    }

    @PostMapping
    public Document create(@Valid @RequestBody Document document) {
        documentRepository.save(document);
        return document;
    }

    @GetMapping(path = "/{id}")
    public Document read(@PathVariable Long id) {
        Optional<Document> document = documentRepository.findById(id);
        if (document.isPresent()) {
            return document.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, DOCUMENT_NOT_FOUND);
    }

    @PutMapping(path = "/{id}")
    public Document update(@PathVariable Long id, @Valid @RequestBody Document document) {
        if (!documentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, DOCUMENT_NOT_FOUND);
        }
        return documentRepository.save(document);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Long id) {
        if (!documentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, DOCUMENT_NOT_FOUND);
        }
        documentRepository.deleteById(id);
    }

}

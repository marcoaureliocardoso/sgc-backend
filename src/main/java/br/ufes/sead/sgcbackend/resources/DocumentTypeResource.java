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

import br.ufes.sead.sgcbackend.entities.DocumentType;
import br.ufes.sead.sgcbackend.repositories.DocumentTypeRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/documenttypes")
public class DocumentTypeResource {

    private static final String DOCUMENT_TYPE_NOT_FOUND = "DocumentType not found";
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
    public DocumentType create(@Valid @RequestBody DocumentType documentType) {
        documentTypeRepository.save(documentType);
        return documentType;
    }

    @GetMapping(path = "/{id}")
    public DocumentType read(@PathVariable Long id) {
        Optional<DocumentType> documentType = documentTypeRepository.findById(id);
        if (documentType.isPresent()) {
            return documentType.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, DOCUMENT_TYPE_NOT_FOUND);
    }

    @PutMapping(path = "/{id}")
    public DocumentType update(@PathVariable Long id, @Valid @RequestBody DocumentType documentType) {
        if (!documentTypeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, DOCUMENT_TYPE_NOT_FOUND);
        }
        return documentTypeRepository.save(documentType);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Long id) {
        if (!documentTypeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, DOCUMENT_TYPE_NOT_FOUND);
        }
        documentTypeRepository.deleteById(id);
    }

}

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

import br.ufes.sead.sgcbackend.models.Applicant;
import br.ufes.sead.sgcbackend.repositories.ApplicantRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantRepository applicantRepository;

    @GetMapping
    public Iterable<Applicant> list(
            @RequestParam(name = "paginated", defaultValue = "true") String paginated,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "sortBy", defaultValue = "name") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {
        if (!paginated.equals("false")) {
            String sortKey = (Applicant.getSortKeysSet().contains(sortBy)) ? sortBy : "name";
            Direction direction = (sortDirection.equals("asc")) ? Direction.ASC : Direction.DESC;
            Pageable pageable = PageRequest.of(page, 10, Sort.by(direction, sortKey));

            return applicantRepository.findAll(pageable);
        }

        return applicantRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Applicant create(@Valid @RequestBody Applicant applicant) {
        applicantRepository.save(applicant);
        return applicant;
    }

    @GetMapping(path = "/{id}")
    public Applicant read(@PathVariable Integer id) {
        Optional<Applicant> applicant = applicantRepository.findById(id);
        if (applicant.isPresent()) {
            return applicant.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Applicant not found");
    }

    @PutMapping(path = "/{id}")
    public Applicant update(@PathVariable Integer id, @Valid @RequestBody Applicant applicant) {
        if (!applicantRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Applicant not found");
        }
        return applicantRepository.save(applicant);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Integer id) {
        if (!applicantRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Applicant not found");
        }
        applicantRepository.deleteById(id);

    }
}

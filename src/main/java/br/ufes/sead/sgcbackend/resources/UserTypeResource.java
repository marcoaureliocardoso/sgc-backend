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

import br.ufes.sead.sgcbackend.entities.UserType;
import br.ufes.sead.sgcbackend.repositories.UserTypeRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/usertypes")
public class UserTypeResource {

    private static final String USER_TYPE_NOT_FOUND = "UserType not found";
    @Autowired
    private UserTypeRepository userTypeRepository;

    @GetMapping
    public Iterable<UserType> list(
            @RequestParam(name = "paginated", defaultValue = "true") String paginated,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "sortBy", defaultValue = "name") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {
        if (!paginated.equals("false")) {
            String sortKey = (UserType.getSortKeysSet().contains(sortBy)) ? sortBy : "name";
            Direction direction = (sortDirection.equals("asc")) ? Direction.ASC : Direction.DESC;
            Pageable pageable = PageRequest.of(page, 10, Sort.by(direction, sortKey));

            return userTypeRepository.findAll(pageable);
        }

        return userTypeRepository.findAll();
    }

    @PostMapping
    public UserType create(@Valid @RequestBody UserType userType) {
        userTypeRepository.save(userType);
        return userType;
    }

    @GetMapping(path = "/{id}")
    public UserType read(@PathVariable Long id) {
        Optional<UserType> userType = userTypeRepository.findById(id);
        if (userType.isPresent()) {
            return userType.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, USER_TYPE_NOT_FOUND);
    }

    @PutMapping(path = "/{id}")
    public UserType update(@PathVariable Long id, @Valid @RequestBody UserType userType) {
        if (!userTypeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, USER_TYPE_NOT_FOUND);
        }
        return userTypeRepository.save(userType);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Long id) {
        if (!userTypeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, USER_TYPE_NOT_FOUND);
        }
        userTypeRepository.deleteById(id);
    }
}

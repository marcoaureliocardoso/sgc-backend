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

import br.ufes.sead.sgcbackend.entities.User;
import br.ufes.sead.sgcbackend.repositories.UserRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserResource {

    private static final String USER_NOT_FOUND = "User not found";
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Iterable<User> list(
            @RequestParam(name = "paginated", defaultValue = "true") String paginated,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "sortBy", defaultValue = "login") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {
        if (!paginated.equals("false")) {
            String sortKey = (User.getSortKeysSet().contains(sortBy)) ? sortBy : "login";
            Direction direction = (sortDirection.equals("asc")) ? Direction.ASC : Direction.DESC;
            Pageable pageable = PageRequest.of(page, 10, Sort.by(direction, sortKey));

            return userRepository.findAll(pageable);
        }

        return userRepository.findAll();
    }

    @PostMapping
    public User create(@Valid @RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @GetMapping(path = "/{id}")
    public User read(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, USER_NOT_FOUND);
    }

    @PutMapping(path = "/{id}")
    public User update(@PathVariable Long id, @Valid @RequestBody User user) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, USER_NOT_FOUND);
        }
        return userRepository.save(user);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, USER_NOT_FOUND);
        }
        userRepository.deleteById(id);
    }

}

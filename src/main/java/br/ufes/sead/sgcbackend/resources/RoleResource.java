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

import br.ufes.sead.sgcbackend.entities.Role;
import br.ufes.sead.sgcbackend.repositories.RoleRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/roles")
public class RoleResource {

    private static final String ROLE_NOT_FOUND = "Role not found";
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public Iterable<Role> list(
            @RequestParam(name = "paginated", defaultValue = "true") String paginated,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "sortBy", defaultValue = "name") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {
        if (!paginated.equals("false")) {
            String sortKey = (Role.getSortKeysSet().contains(sortBy)) ? sortBy : "name";
            Direction direction = (sortDirection.equals("asc")) ? Direction.ASC : Direction.DESC;
            Pageable pageable = PageRequest.of(page, 10, Sort.by(direction, sortKey));

            return roleRepository.findAll(pageable);
        }

        return roleRepository.findAll();
    }

    @PostMapping
    public Role create(@Valid @RequestBody Role role) {
        roleRepository.save(role);
        return role;
    }

    @GetMapping(path = "/{id}")
    public Role read(@PathVariable Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()) {
            return role.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, ROLE_NOT_FOUND);
    }

    @PutMapping(path = "/{id}")
    public Role update(@PathVariable Long id, @Valid @RequestBody Role role) {
        if (!roleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ROLE_NOT_FOUND);
        }
        return roleRepository.save(role);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Long id) {
        if (!roleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ROLE_NOT_FOUND);
        }
        roleRepository.deleteById(id);
    }

}

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

import br.ufes.sead.sgcbackend.entities.Employee;
import br.ufes.sead.sgcbackend.repositories.EmployeeRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/employees")
public class EmployeeResource {

    private static final String EMPLOYEE_NOT_FOUND = "Employee not found";
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public Iterable<Employee> list(
            @RequestParam(name = "paginated", defaultValue = "true") String paginated,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "sortBy", defaultValue = "name") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {
        if (!paginated.equals("false")) {
            String sortKey = (Employee.getSortKeysSet().contains(sortBy)) ? sortBy : "name";
            Direction direction = (sortDirection.equals("asc")) ? Direction.ASC : Direction.DESC;
            Pageable pageable = PageRequest.of(page, 10, Sort.by(direction, sortKey));

            return employeeRepository.findAll(pageable);
        }

        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee create(@Valid @RequestBody Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @GetMapping(path = "/{id}")
    public Employee read(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, EMPLOYEE_NOT_FOUND);
    }

    @PutMapping(path = "/{id}")
    public Employee update(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        if (!employeeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, EMPLOYEE_NOT_FOUND);
        }
        return employeeRepository.save(employee);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, EMPLOYEE_NOT_FOUND);
        }
        employeeRepository.deleteById(id);
    }

}

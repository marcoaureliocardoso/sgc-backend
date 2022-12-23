package br.ufes.sead.sgcbackend.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.ufes.sead.sgcbackend.dtos.EmployeeDto;
import br.ufes.sead.sgcbackend.models.Employee;
import br.ufes.sead.sgcbackend.repositories.EmployeeRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public Iterable<Employee> index() {
        Iterable<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @GetMapping(path = "/create")
    public String create() {
        return "Create Employee";
    }

    @PostMapping
    public @ResponseBody Employee store(@Valid @RequestBody Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @GetMapping(path = "/{id}")
    public Employee show(@PathVariable Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
    }

    @GetMapping(path = "/{id}/edit")
    public String edit(@PathVariable int id) {
        return "Edit Employee 1";
    }
    
    @PutMapping(path = "/{id}")
    public Employee update(@PathVariable Integer id, @Valid @RequestBody Employee employee) {
        if (!employeeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        return employeeRepository.save(employee);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable int id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        employeeRepository.deleteById(id);
    }

}

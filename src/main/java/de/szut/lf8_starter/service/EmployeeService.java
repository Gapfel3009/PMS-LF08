package de.szut.lf8_starter.service;

import de.szut.lf8_starter.model.Employee;
import de.szut.lf8_starter.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = repository.findAll();
        return ResponseEntity.ok(employees);
    }

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }
}

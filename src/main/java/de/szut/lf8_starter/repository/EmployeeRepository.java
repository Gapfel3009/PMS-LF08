package de.szut.lf8_starter.repository;

import de.szut.lf8_starter.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

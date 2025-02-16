package de.szut.lf8_starter;

import de.szut.lf8_starter.model.Employee;
import de.szut.lf8_starter.model.Project;
import de.szut.lf8_starter.service.EmployeeService;
import de.szut.lf8_starter.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {



    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
        try {
            this.employeeService.createEmployee(employee);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployee() {
        return employeeService.getEmployees();
    }

}

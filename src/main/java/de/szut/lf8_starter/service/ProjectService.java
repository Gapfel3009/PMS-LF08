package de.szut.lf8_starter.service;

import de.szut.lf8_starter.model.Employee;
import de.szut.lf8_starter.model.Project;
import de.szut.lf8_starter.repository.EmployeeRepository;
import de.szut.lf8_starter.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    final ProjectRepository repository;
    final EmployeeRepository employeeRepository;

public void delete(long id) {
    if(repository.existsById(id))
    {
        repository.deleteById(id);
    }
}
public Project createProject(Project project) {
    return repository.save(project);
}

public ResponseEntity<List<Project>> getProjects(){
    List<Project> projects = repository.findAll();
    return ResponseEntity.ok(projects);
}

public ResponseEntity<Project> getProjectDetails(long id) {
    Optional<Project> project = repository.findById(id);
    return project.isPresent() ? ResponseEntity.ok(project.get()) : ResponseEntity.notFound().build();
}

public ResponseEntity<List<Employee>> getProjectEmployees(long id) {
    return repository.findById(id)
            .map(project -> {
                List<Employee> employees = employeeRepository.findAllById(project.getEmployee_id());
                return ResponseEntity.ok(employees);
            })
            .orElse(ResponseEntity.notFound().build());
}
}

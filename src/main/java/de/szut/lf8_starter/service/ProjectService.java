package de.szut.lf8_starter.service;

import de.szut.lf8_starter.exceptionHandling.ResourceNotFoundException;
import de.szut.lf8_starter.model.Employee;
import de.szut.lf8_starter.model.Project;
import de.szut.lf8_starter.repository.EmployeeRepository;
import de.szut.lf8_starter.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

public Project updateProject(long id, Project project) {
        Optional<Project> existingOptionalProject = repository.findById(id);
        if(existingOptionalProject.isPresent()) {
            Project existingProject = existingOptionalProject.get();

            existingProject.setBezeichnung(project.getBezeichnung());
            existingProject.setVerMAid(project.getVerMAid());
            existingProject.setZuMAname(project.getZuMAname());
            existingProject.setKundenId(project.getKundenId());
            existingProject.setKommentar(project.getKommentar());
            existingProject.setStartdatum(project.getStartdatum());
            existingProject.setGeplantesEnddatum(project.getGeplantesEnddatum());
            existingProject.setTatsaechlichesEnddatum(project.getTatsaechlichesEnddatum());
            existingProject.setEmployee_id(project.getEmployee_id());
            return repository.save(existingProject);
        }else{
            throw new ResourceNotFoundException("Projekt mit der ID " + id +" nicht gefunden");
        }
}

    public ResponseEntity<String> addEmployeesToProject(long projectId, List<Long> employeeIds) {
        Optional<Project> optionalProject = repository.findById(projectId);

        if (optionalProject.isEmpty()) {
            throw new ResourceNotFoundException("Projekt nicht gefunden.");
        }

        Project project = optionalProject.get();
        List<Long> existingEmployees = project.getEmployee_id();
        List<Long> employeeIdsToAdd = new ArrayList<>();

        for (Long employeeId : employeeIds) {
            if (!existingEmployees.contains(employeeId) && repository.findById(employeeId).isEmpty()) {
                employeeIdsToAdd.add(employeeId);
            }
        }

        existingEmployees.addAll(employeeIdsToAdd);
        project.setEmployee_id(existingEmployees);
        repository.save(project);
        return ResponseEntity.ok("Mitarbeiter erfolgreich hinzugefügt.");
    }
}
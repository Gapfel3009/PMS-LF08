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
            throw new RuntimeException("Projekt mit der ID " + id +" nicht gefunden");
        }
}

    public void putEmployeeByID(long id, long employeeId) {
        Optional<Project> optionalProjectproject = repository.findById(id);
        if(optionalProjectproject.isPresent()) {
            Project project = optionalProjectproject.get();
            if(repository.findOverlapsDate(employeeId,project.getStartdatum(), project.getGeplantesEnddatum()).isEmpty()){
                List<Long> newEmployeeList = project.getEmployee_id();
                newEmployeeList.add(employeeId);
                project.setEmployee_id(newEmployeeList);
                repository.save(project);
            }else {
                throw new RuntimeException("Die Zeiträume anderer Projekte überschneiden sich für diesen Mitarbeiter");
            }

        }
    }

}

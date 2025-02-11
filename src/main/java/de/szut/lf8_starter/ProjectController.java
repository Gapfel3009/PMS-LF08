package de.szut.lf8_starter;

import de.szut.lf8_starter.model.Employee;
import de.szut.lf8_starter.model.Project;
import de.szut.lf8_starter.service.ProjectService;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {


    private final EnableSpringDataWebSupport.SpringDataWebConfigurationImportSelector springDataWebConfigurationImportSelector;
    ProjectService projectService;

    public ProjectController(EnableSpringDataWebSupport.SpringDataWebConfigurationImportSelector springDataWebConfigurationImportSelector) {
        this.springDataWebConfigurationImportSelector = springDataWebConfigurationImportSelector;
    }

    @PostMapping
    public void createProject(@RequestBody Project project) {
        try {
            this.projectService.createProject(project);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

@GetMapping
public ResponseEntity<List<Project>> getAllProjects() {
    return projectService.getProjects();
}
@DeleteMapping("/{id}")
    public void deleteProject(@PathVariable int id) {
    try {
        projectService.delete(id);
    }catch (Exception e) {
        System.out.println(e);
    }
}
@GetMapping("/{id}")
public ResponseEntity<Project> getProjectDetails(@PathVariable int id) {
    try{
        return projectService.getProjectDetails(id);
    }catch (Exception e) {
        System.out.println(e);
    }
    return null;
}

@GetMapping("/{id}/employee")
    public ResponseEntity<List<Employee>> getProjectEmployees(@PathVariable int id) {
    try{
        return projectService.getProjectEmployees(id);
    } catch (Exception e) {
        System.out.println(e);
    }
    return null;
}

}

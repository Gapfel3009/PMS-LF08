package de.szut.lf8_starter.mapper;

import de.szut.lf8_starter.dto.ProjectDTO;
import de.szut.lf8_starter.model.Project;

public class ProjectMapper {

    public Project DtoToProject (ProjectDTO projectDTO) {
        Project project = new Project();
        project.setId(projectDTO.getId());
        project.setBezeichnung(projectDTO.getBezeichnung());
        project.setKommentar(projectDTO.getKommentar());
        project.setStartdatum(projectDTO.getStartdatum());
        project.setGeplantesEnddatum(projectDTO.getGeplantesEnddatum());
        project.setTatsaechlichesEnddatum(projectDTO.getTatsaechlichesEnddatum());
        project.setVerMAid(projectDTO.getVerMAid());
        project.setZuMAname(projectDTO.getZuMAname());
        project.setKundenId(projectDTO.getKundenId());
        project.setEmployeeId(projectDTO.getEmployeeId());
        return project;
    }
}

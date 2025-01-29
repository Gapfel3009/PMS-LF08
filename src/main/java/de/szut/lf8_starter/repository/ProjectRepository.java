package de.szut.lf8_starter.repository;

import de.szut.lf8_starter.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}

package de.szut.lf8_starter.repository;

import de.szut.lf8_starter.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value = "SELECT p.project_id FROM project_employee_id AS pei INNER JOIN project AS p ON p.project_id = pei.project_project_id WHERE (p.project_start_datum, p.project_geplantes_enddatum) OVERLAPS (:startDate, :endDate) AND pei.employee_id = :employeeId", nativeQuery = true)
    List<Integer> findOverlapsDate(@Param("employeeId") Long employeeId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}

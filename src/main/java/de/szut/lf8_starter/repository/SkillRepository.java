package de.szut.lf8_starter.repository;

import de.szut.lf8_starter.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}

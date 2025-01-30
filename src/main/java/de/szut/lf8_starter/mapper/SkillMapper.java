package de.szut.lf8_starter.mapper;

import de.szut.lf8_starter.dto.SkillDTO;
import de.szut.lf8_starter.model.Skill;

public class SkillMapper {
    public Skill DTOToSkill(SkillDTO skillDTO) {
        Skill skill = new Skill();
        skill.setId(skillDTO.getId());
        skill.setSkillName(skillDTO.getName());
        return skill;
    }
}

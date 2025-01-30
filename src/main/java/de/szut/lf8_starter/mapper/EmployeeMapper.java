package de.szut.lf8_starter.mapper;

import de.szut.lf8_starter.dto.EmployeeDTO;
import de.szut.lf8_starter.model.Employee;
import de.szut.lf8_starter.model.Skill;

import java.util.List;

public class EmployeeMapper {
    private final SkillMapper skillMapper;

    public EmployeeMapper(SkillMapper skillMapper) {
        this.skillMapper = skillMapper;
    }

    public Employee DtoToEmployee (EmployeeDTO employeeDTO) {

        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setCity(employeeDTO.getCity());
        employee.setPhone(employeeDTO.getPhone());
        employee.setPostcode(employeeDTO.getPostcode());
        employee.setStreet(employeeDTO.getStreet());
        List<Skill> mapped = employeeDTO
                .getSkillSet()
                .stream()
                .map(skillMapper::DTOToSkill)
                .toList();
        employee.setSkillSet(mapped);

        return employee;
    }
}

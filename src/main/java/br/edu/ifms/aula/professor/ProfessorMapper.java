/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aula.professor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author 1513003
 */
@Mapper
public interface ProfessorMapper {

    public static final ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

    public ProfessorDto toDto(Professor entity);

    public List<ProfessorDto> map(List<Professor> items);

    @Mapping(target = "id", ignore = true)
    public void update(ProfessorForm dto, @MappingTarget Professor entity);

    @Mapping(target = "id", ignore = true)
    public Professor toEntity(ProfessorForm form);
}

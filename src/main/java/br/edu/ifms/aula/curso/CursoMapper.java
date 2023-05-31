/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.aula.curso;

import br.edu.ifms.arch.BaseObjectMapper;
import br.edu.ifms.arch.ISimpleMapper;
import br.edu.ifms.aula.campus.CampusMapper;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author nicho
 */
@Mapper(
        config = BaseObjectMapper.class,
        uses = {CampusMapper.class}
)
public interface CursoMapper extends ISimpleMapper<Curso, CursoDto, CursoForm> {

    public static final CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

    @InheritConfiguration(name = "toEntity")
    @Override
    public Curso formToEntity(CursoForm dto);

    @Override
    public Curso dtoToEntity(CursoDto dto);

    @Override
    public CursoDto toDto(Curso entity);

    @InheritConfiguration(name = "update")
    @Override
    public Curso update(CursoForm dto, @MappingTarget Curso entity);

    @Override
    public List<Curso> toEntityList(List<CursoDto> items);

    @Override
    public List<CursoDto> toDtoList(List<Curso> items);

    @Override
    public default Page<CursoDto> toDtoPage(Page<Curso> items) {
        return items.map(entity -> toDto(entity));
    }
}

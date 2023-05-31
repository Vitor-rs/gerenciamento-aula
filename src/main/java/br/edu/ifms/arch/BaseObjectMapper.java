/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.arch;

import br.edu.ifms.arch.dto.AdapterBaseObjectDto;
import br.edu.ifms.arch.dto.AdapterBaseObjectForm;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author 1513003
 */
@MapperConfig(
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface BaseObjectMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    IBase toEntity(AdapterBaseObjectForm dto);

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    IBase toEntity(AdapterBaseObjectDto dto);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    void update(AdapterBaseObjectForm dto, @MappingTarget IBase entity);

    AdapterBaseObjectDto toDto(IBase entity);

    public List<AdapterBaseObjectDto> setMap(List<IBase> items);

    default Page<AdapterBaseObjectDto> pageMap(Page<IBase> items) {
        return items.map(obj -> {
            return toDto(obj);
        });
    }
}

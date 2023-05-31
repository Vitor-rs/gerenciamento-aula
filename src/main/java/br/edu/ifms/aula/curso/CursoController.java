/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aula.curso;

import br.edu.ifms.arch.controller.AbstractBasicController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @author nicho
 */
@RestController
@RequestMapping("/api/curso")
public class CursoController extends AbstractBasicController<Curso, CursoDto, CursoForm, CursoRepository, CursoService, Long> {

    @Autowired
    @Override
    public void setService(CursoService service) {
        this.service = service;
        setMapper(CursoMapper.INSTANCE);
    }

    @Override
    public URI createUri(Curso entity, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/curso/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
    }

}

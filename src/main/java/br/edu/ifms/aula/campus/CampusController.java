/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aula.campus;

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
@RequestMapping("/api/campus")
public class CampusController extends AbstractBasicController<Campus, CampusDto, CampusForm, CampusRepository, CampusService, Long> {

    @Autowired
    @Override
    public void setService(CampusService service) {
        this.service = service;
        setMapper(CampusMapper.INSTANCE);
    }

    @Override
    public URI createUri(Campus entity, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/campus/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
    }

}

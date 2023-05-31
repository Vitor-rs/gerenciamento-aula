/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aula.campus;

import br.edu.ifms.arch.service.AbstractBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nicho
 */
@Service
public class CampusService extends AbstractBasicService<Campus, Long, CampusForm, CampusRepository> {

    @Autowired
    @Override
    public void setRepository(CampusRepository repository) {
        super.repository = repository;
        setMapper(CampusMapper.INSTANCE);
    }
}

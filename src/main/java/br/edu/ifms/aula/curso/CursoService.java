/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aula.curso;

import br.edu.ifms.arch.service.AbstractBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nicho
 */
@Service
public class CursoService extends AbstractBasicService<Curso, Long, CursoForm, CursoRepository> {

    @Autowired
    @Override
    public void setRepository(CursoRepository repository) {
        super.repository = repository;
        setMapper(CursoMapper.INSTANCE);
    }
}

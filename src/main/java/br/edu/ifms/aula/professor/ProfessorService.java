/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aula.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author 1513003
 */
@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public List<Professor> listar() {
        return repository.findAll();
    }

    public Professor salvar(Professor entity) {
        Professor p = repository.save(entity);
        return p;
    }

    public Professor atualizar(Long id, ProfessorForm form) {
        Professor entity = buscarPorId(id);
        ProfessorMapper.INSTANCE.update(form, entity);
        return entity;
    }

    public Professor buscarPorId(Long id) {
        Optional<Professor> optional = repository.findById(id);
        if (optional.isEmpty()) {
            String msg = "Não existe Professor para o código [%d] informado";
            throw new ProfessorNotFoundException(String.format(msg, id));
        }
        return optional.get();
    }

    public void excluir(Long id) {
        Professor entity = buscarPorId(id);
        repository.delete(entity);
    }
}

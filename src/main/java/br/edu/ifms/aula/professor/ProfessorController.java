/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aula.professor;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 1513003
 */
@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    @Autowired // faz o Spring criar uma inst�ncia de ProfessorService
    private ProfessorService service;

    @GetMapping
    public ResponseEntity<List<ProfessorDto>> listar() {
        List<Professor> listaEntity = service.listar();
        List<ProfessorDto> listaDto = ProfessorMapper.INSTANCE.map(listaEntity);
        return ResponseEntity.ok(listaDto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProfessorDto> cadastrar(
            @RequestBody @Valid ProfessorForm form) {
        Professor entity = ProfessorMapper.INSTANCE.toEntity(form);
        service.salvar(entity);
        ProfessorDto dto = ProfessorMapper.INSTANCE.toDto(entity);
        return ResponseEntity.accepted().body(dto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProfessorDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid ProfessorForm form) {
        Professor entity = service.atualizar(id, form);
        ProfessorDto dto = ProfessorMapper.INSTANCE.toDto(entity);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }

}

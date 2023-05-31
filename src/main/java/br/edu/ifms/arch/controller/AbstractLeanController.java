/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.arch.controller;

import br.edu.ifms.arch.ILeanMapper;
import br.edu.ifms.arch.MapperUtils;
import br.edu.ifms.arch.repository.IArchRepository;
import br.edu.ifms.arch.service.IService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @param <T>
 * @param <K>
 * @param <DTO>
 * @param <LEANDTO>
 * @param <F>
 * @param <R>
 * @param <S>
 * @author nicho
 */
@RestController
@Profile(value = {"prod", "test", "dev"})
public abstract class AbstractLeanController<
        T, K, DTO, LEANDTO, F,
        R extends IArchRepository<T, K>,
        S extends IService<T, K, F, R>>
        extends AdapterLeanController<T, K, DTO, LEANDTO, F, S> {

    protected S service;
    protected ILeanMapper<T, DTO, LEANDTO, F> mapper;

    public abstract void setService(S service);

    protected void validate() {
        MapperUtils.validate(AbstractLeanController.class, mapper);
    }

    public void setMapper(ILeanMapper<T, DTO, LEANDTO, F> mapper) {
        this.mapper = mapper;
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<LEANDTO>> listarLean(
            @PageableDefault(page = 0, size = 10) Pageable paginacao) {
        this.validate();

        var page = service.listar(paginacao);
        return ResponseEntity
                .ok(mapper.toLeanDtoPage(page));
    }

    @GetMapping("/page-not-used")
    @Override
    public ResponseEntity<Page<DTO>> listar(Pageable paginacao) {
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/list")
    @Override
    public List<LEANDTO> listarLean() {
        this.validate();
        var list = service.listar();
        return mapper.toLeanDtoList(list);
    }

    @GetMapping("/list-not-used")
    @Override
    public List<DTO> listar() {
        return null;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DTO> visualizar(@PathVariable K id) {
        this.validate();
        return service.buscarPor(id)
                .map(entity -> ResponseEntity
                        .ok(mapper.toDto(entity)))
                .orElse(ResponseEntity.notFound().build());
    }

    public URI createUri(UriComponentsBuilder uriBuilder) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping
    @Transactional
    @Override
    public ResponseEntity<DTO> cadastrar(
            @RequestBody @Valid F form,
            UriComponentsBuilder uriBuilder) {
        this.validate();
        var entity = service.criar(form);
        var dto = mapper.toDto(entity);
        var uri = createUri(uriBuilder);
        return ResponseEntity.created(uri).body(dto);
    }

    @Override
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DTO> atualizar(@PathVariable K id, @RequestBody @Valid F form) {
        this.validate();
        var entity = service.atualizar(id, form);
        var dto = mapper.toDto(entity);
        return ResponseEntity.ok(dto);
    }

    @Override
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable K id) {
        service.remover(id);
        return ResponseEntity.ok().build();
    }

}

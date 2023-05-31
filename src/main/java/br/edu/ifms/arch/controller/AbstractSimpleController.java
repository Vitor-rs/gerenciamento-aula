/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.arch.controller;

import br.edu.ifms.arch.ISimpleMapper;
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
 * @param <F>
 * @param <R>
 * @param <S>
 * @author nicho
 */
@RestController
@Profile(value = {"prod", "test", "dev"})
public abstract class AbstractSimpleController<
        T, K, DTO, F, R extends IArchRepository<T, K>,
        S extends IService<T, K, F, R>>
        implements ISimpleController<T, K, DTO, F> {

    protected S service;
    protected ISimpleMapper<T, DTO, F> mapper;

    public abstract void setService(S service);

    protected void setMapper(ISimpleMapper<T, DTO, F> mapper) {
        this.mapper = mapper;
    }

    protected void validate() {
        MapperUtils.validate(AbstractSimpleController.class, mapper);
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<DTO>> listar(
            @PageableDefault(page = 0, size = 10) Pageable paginacao) {
        this.validate();

        var page = service.listar(paginacao);
        return ResponseEntity.ok(mapper.toDtoPage(page));
    }

    @GetMapping("/list")
    @Override
    public List<DTO> listar() {
        this.validate();
        var entityList = service.listar();
        return mapper.toDtoList(entityList);
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

    public URI createUri(T entity, UriComponentsBuilder uriBuilder) {
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
        var uri = createUri(entity, uriBuilder);
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    @Transactional
    @Override
    public ResponseEntity<DTO> atualizar(
            @PathVariable K id,
            @RequestBody @Valid F form) {
        this.validate();
        var entity = service.atualizar(id, form);
        var dto = mapper.toDto(entity);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Override
    public ResponseEntity<?> remover(K id) {
        service.remover(id);
        return ResponseEntity.ok().build();
    }

}

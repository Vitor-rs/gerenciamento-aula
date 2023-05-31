/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.arch.service;

import br.edu.ifms.arch.ISimpleMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Interface para Servicos.
 * Interface utilizada para definir os métodos básicos para a
 * implementação dos serviços básicos que serão disponibilizados
 * para a aplicação.
 *
 * @param <T> Classe de Negócio a ser implementada
 * @param <K> Classe que representa a chave primária da Classe de Negócio
 * @param <F> Classe que representa o formulário no padrão DTO da Classe de Negócio
 * @param <R> Classe que representa o padrão Repository da classe de negócio
 * @author nicho
 * @since 02/11/2022
 */
public interface IService<T, K, F, R> {

    /**
     * Atribui��o do Repository.
     * Este m�todo tem a finalidade de determinar qual ser� o
     * objeto que representa a classe de persistência de dados
     * no banco de dados conforme o padr�o Repository.
     *
     * @param repository
     */
    void setRepository(R repository);

    /**
     * Atribui��o do Objeto de Mapeamento. Atribui��o do objeto
     * respons�vel por mapear um DTO to Entity e vice-versa
     *
     * @param mapper
     */
    void setMapper(ISimpleMapper mapper);

    /**
     * Listagem de dados. Este m�todo tem a finalidade de buscar uma lista de
     * dados da Classe de Neg�cio <T> de acordo com a descri��o do par�metro
     * NOME e da PAGINACAO
     *
     * @param paginacao Objeto da classe <class>Pageable</class>
     * @return Retorna um objeto da classe <class>Page<T></class>.
     * @since 11-02-2022
     */
    Page<T> listar(Pageable paginacao);

    /**
     * Listagem de dados. Este m�todo tem a finalidade de buscar uma lista de
     * dados da Classe de Neg�cio <T>.
     *
     * @return Retorna um objeto da classe <class>Set<T></class>
     */
    List<T> listar();

    /**
     * Buscar dados por ID.
     * Este m�todo tem a finalidade de buscar um Objeto da Classe
     * de Neg�cio <K> filtrado pela sua chave prim�ria <K>
     *
     * @param id
     * @return Retorna um objeto da classe <class>Optional</class>.
     */
    Optional<T> buscarPor(K id);

    T criar(F form);

    T atualizar(K id, F form);

    T remover(K id);

}

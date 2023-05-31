/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.arch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @param <T>
 * @param <K>
 * @author nicho
 */
public interface IArchRepository<T, K>
        extends JpaRepository<T, K>,
        JpaSpecificationExecutor<T> {

}

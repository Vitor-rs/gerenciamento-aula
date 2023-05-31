/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.arch;

import java.time.LocalDateTime;

/**
 * @author 1513003
 */
public interface IBase {

    public Long getId();

    public void setId(Long id);

    public String getNome();

    public void setNome(String nome);

    public LocalDateTime getCreatedAt();

    public void setCreatedAt(LocalDateTime value);

}

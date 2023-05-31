/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aula.professor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

/**
 * @author 1513003
 */
@Entity // Cria uma tabela no SGBD com o mesmo nome da classe
@Data // Implementa os métodos GET e SET para cada atributo
@EqualsAndHashCode // Cria os métodos equals e hashCode que é utilizado para comparação
@AllArgsConstructor // cria construtores com todos os atributos
@NoArgsConstructor // cria construtor sem parâmetros
@Builder // padrão de projeto para construção de objetos
public class Professor implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
}

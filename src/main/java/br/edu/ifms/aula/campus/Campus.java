/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aula.campus;

import br.edu.ifms.arch.BaseObject;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author nicholas.santos
 */
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(sequenceName = "campus_sequence", name = "baseObjectSequence", allocationSize = 1)
public class Campus extends BaseObject {

}

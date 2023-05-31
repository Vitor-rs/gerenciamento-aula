/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.arch;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @param <T>
 * @param <DTO>
 * @param <LEANDTO>
 * @param <FORM>
 * @author nicho
 */
public interface ILeanMapper<T, DTO, LEANDTO, FORM>
        extends ISimpleMapper<T, DTO, FORM> {

    public LEANDTO toLeanDto(T entity);

    public List<LEANDTO> toLeanDtoList(List<T> items);

    public default Page<LEANDTO> toLeanDtoPage(Page<T> items) {
        return items.map(entity -> toLeanDto(entity));
    }
}

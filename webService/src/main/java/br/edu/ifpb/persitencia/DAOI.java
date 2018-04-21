/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.persitencia;



/**
 *
 * @author laerton
 */
public interface DAOI <T> {

    T delete(Long id);

    T getById(long id);

    T save(T abastecimento);

    T update(T abastecimento);
    
}

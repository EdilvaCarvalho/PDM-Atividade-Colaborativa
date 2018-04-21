/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.persitencia;


import br.edu.ifpb.modelo.PostoDeCombustivel;
import br.edu.ifpb.modelo.exception.DAOException;
import br.edu.ifpb.modelo.exception.ErrorCode;

/**
 *
 * @author laerton
 */
public class PostoDAO extends AbstractDAO<PostoDeCombustivel>{

    @Override
    public PostoDeCombustivel update(PostoDeCombustivel objeto) {
        if (objeto.getId() <= 0) {
            throw new DAOException("O id precisa ser maior do que 0.", ErrorCode.BAD_REQUEST.getCode());
        }
        return super.update(objeto); 
    }
    
    
    
    
    
}

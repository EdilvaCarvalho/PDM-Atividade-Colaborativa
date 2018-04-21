/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.service;

import br.edu.ifpb.modelo.PostoDeCombustivel;
import br.edu.ifpb.persitencia.PostoDAO;



/**
 *
 * @author laerton
 */
public class PostoService {
    private PostoDAO dao = new PostoDAO();
    
    public PostoDeCombustivel findPosto(long id){
        return dao.getById(PostoDeCombustivel.class, id);
    }
    
    public void deletar (PostoDeCombustivel posto){
        dao.delete(posto);
    }
    
    public PostoDeCombustivel salvar (PostoDeCombustivel posto){
        if (posto.getId() == 0){
            return dao.save(posto);
        }
        return dao.update(posto);
    }
    
    

}

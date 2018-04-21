/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.service;

import br.edu.ifpb.modelo.Usuario;
import br.edu.ifpb.persitencia.UsuarioDAO;


/**
 *
 * @author laerton
 */
public class UsuarioService {

    private UsuarioDAO dao = new UsuarioDAO();

    public Usuario findUser (long id){
        return dao.getById(Usuario.class, id);
    }
    
    public void deletar(Usuario user){
        dao.delete(user);
    }
    
    public Usuario salvar(Usuario user){
        if (user.getId() == 0){
            return dao.save(user);
        }
        return dao.update(user);
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.persitencia;

import br.edu.ifpb.modelo.exception.DAOException;
import br.edu.ifpb.modelo.exception.ErrorCode;
import javax.persistence.EntityManager;



/**
 *
 * @author laerton
 */
public class AbstractDAO<T> {

    
    public T delete(T t) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            T t2 =  em.merge(t);
            em.remove(t2);
            em.getTransaction().commit();
        } catch (IllegalArgumentException ex) {
            em.getTransaction().rollback();
            throw new DAOException("O Objeto informado para remocao nao existe: " + ex.getMessage(), ErrorCode.NOT_FOUND.getCode());
        } catch (RuntimeException ex) {
            em.getTransaction().rollback();
            throw new DAOException("Erro ao remover o objeto do banco de dados: " + ex.getMessage(), ErrorCode.SERVER_ERROR.getCode());
        } finally {
            em.close();
        }
        return t;
    }

    
    public T getById(Class<T> classe , long id) {
       EntityManager em = JPAUtil.getEntityManager();
       T t = null ;
        if (id <=0){
            throw new DAOException("O id precisa ser maior do que 0.", ErrorCode.BAD_REQUEST.getCode());
        }
        try {
            t = em.find(classe, id);
        } catch (RuntimeException ex) {
                     throw new DAOException("Erro ao buscar o objeto por id no banco de dados: " + ex.getMessage(), ErrorCode.SERVER_ERROR.getCode());
        } finally {
            em.close();
        }
        if (t == null ){
             throw new DAOException("O Objeto com id " + id + " não existe.", ErrorCode.NOT_FOUND.getCode());
        }
        return (T) t;
    }

    
    public T save(T objeto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw new DAOException("Erro ao salvar o objeto no banco de dados: " + e.getMessage(), ErrorCode.SERVER_ERROR.getCode());
        }finally{
            em.close();
        }
        return objeto;
    }
    
    public T update(T objeto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(objeto);
            em.getTransaction().commit();
        } catch (NullPointerException ex) {
            em.getTransaction().rollback();
            throw new DAOException("Posto informado para atualizacao nao existe: " + ex.getMessage(), ErrorCode.NOT_FOUND.getCode());
        } catch (RuntimeException ex) {
            em.getTransaction().rollback();
            throw new DAOException("Erro ao atualizar posto no banco de dados: " + ex.getMessage(), ErrorCode.SERVER_ERROR.getCode());
        } finally {
            em.close();
        }
        return objeto;
    }
    
}

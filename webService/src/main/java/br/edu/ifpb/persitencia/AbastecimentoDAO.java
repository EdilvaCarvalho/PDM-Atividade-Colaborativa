/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.persitencia;

import br.edu.ifpb.modelo.Abastecimento;
import br.edu.ifpb.modelo.PostoDeCombustivel;
import br.edu.ifpb.modelo.TipoDeCombustivel;
import br.edu.ifpb.modelo.exception.DAOException;
import br.edu.ifpb.modelo.exception.ErrorCode;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author laerton
 */
public class AbastecimentoDAO extends AbstractDAO<Abastecimento>
{

    @Override
    public Abastecimento update(Abastecimento objeto) {
        if (objeto.getId() <= 0) {
            throw new DAOException("O id precisa ser maior do que 0.", ErrorCode.BAD_REQUEST.getCode());
        }
        return super.update(objeto); 
    }
    /***
     * Método busca o último abastecimento feito do tipo de combustível informado do posto requisitado
     * @param tipo - Tipo de combustível
     * @param posto - Posto de combustível
     * @return Abastecimento
     */
    public Abastecimento findAbastByTipoByPosto(TipoDeCombustivel tipo, long idPosto){
        EntityManager em = JPAUtil.getEntityManager();
        Abastecimento ab = null;
        TypedQuery<Abastecimento> query = em.createQuery("from "
                + "Abastecimento a where a.tipoDeCombustivel = :tipo" +
                " and a.postoDeCombustivelID = :posto order by a.horario", Abastecimento.class);
        return query.setParameter("tipo", tipo).setParameter("posto", idPosto).getResultList().get(0);
    }
   
    public Collection<Abastecimento> findByPostoAndUser(long idPosto, long idUser){
        EntityManager em = JPAUtil.getEntityManager();
        Abastecimento ab = null;
        TypedQuery<Abastecimento> query = em.createQuery("from "
                + "Abastecimento a where a.usuarioID = :userID" +
                " and a.postoDeCombustivelID = :posto order by a.horario", Abastecimento.class);
        return query.setParameter("userID", idUser).setParameter("posto", idPosto).getResultList();
    }
    
    public Collection<Abastecimento> findByUser(long idUser){
        EntityManager em = JPAUtil.getEntityManager();
        Abastecimento ab = null;
        TypedQuery<Abastecimento> query = em.createQuery("from "
                + "Abastecimento a where a.usuarioID = :userID" +
                " order by a.horario", Abastecimento.class);
        return query.setParameter("userID", idUser).getResultList();
    }
    
}

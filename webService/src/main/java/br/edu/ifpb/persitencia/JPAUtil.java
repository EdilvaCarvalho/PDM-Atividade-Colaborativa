/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.persitencia;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author laerton
 */
public class JPAUtil {

    private static EntityManagerFactory emf;
 
    @Produces
    public static EntityManager getEntityManager() {
         if (emf == null) {
            emf = Persistence.createEntityManagerFactory("PUDados");
         }
         return emf.createEntityManager();
    }
    
    
}

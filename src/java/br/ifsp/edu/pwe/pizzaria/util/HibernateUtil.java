
package br.ifsp.edu.pwe.pizzaria.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory entityManagerFactory ;
    
    private HibernateUtil(){
   
    }
    
    public static EntityManager getEntityManager() {
        try {
            if(entityManagerFactory == null)
                entityManagerFactory  = Persistence.createEntityManagerFactory("pizzariaPU");
            return entityManagerFactory.createEntityManager();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
    }
}

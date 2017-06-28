/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.test.dao;

import br.ifsp.edu.pwe.pizzaria.util.HibernateUtil;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Aluno
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotificaoDAOTest {

    public NotificaoDAOTest() {
    }

    @Test
    public void testA_insereNotificacao() {
           
    }

    @AfterClass
    public static void tearDownClass() {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=0").executeUpdate();
        em.createNativeQuery("truncate table notificacao").executeUpdate();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=1").executeUpdate();
        em.getTransaction().commit();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.test.dao;

import br.ifsp.edu.pwe.pizzaria.dao.ClienteDAO;
import br.ifsp.edu.pwe.pizzaria.model.Cliente;
import br.ifsp.edu.pwe.pizzaria.util.HibernateUtil;
import javax.persistence.EntityManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author HOME-PC
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteDAOTest {
  
    private static Cliente cliente;
    
    @BeforeClass
    public static void setUpClass(){
        ClienteDAOTest.tearDownClass();
    }
    @Test  
    public void testA_insereCliente(){
        Cliente c = new Cliente();
        c.setNome("Gabriel");
        c.setEndereco("Rua A");
        c.setComplemento("Residência");
        c.setCidade("Guarulhos");
        c.setEstado("SP");
        c.setNumero("73");
        c.setCep("07022250");
        c.setTelefone(11952050952L);
        ClienteDAOTest.cliente = new ClienteDAO().insert(c);
    }
    
    @Test  
    public void testB_atualizaCliente(){
        Cliente c = new Cliente();
        c.setId(ClienteDAOTest.cliente.getId());
        c.setNome("Gabriel Martins");
        c.setEndereco("Rua B");
        c.setComplemento("Residência");
        c.setCidade("Guarulhos");
        c.setEstado("SP");
        c.setNumero("73");
        c.setCep("07022250");
        c.setTelefone(11952050952L);
        new ClienteDAO().update(c);
    }
    
    
    @Test  
    public void testC_deletaCliente(){
        new ClienteDAO().delete(ClienteDAOTest.cliente.getId());
    }
    
    @AfterClass
    public static void tearDownClass(){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=0").executeUpdate();
        em.createNativeQuery("truncate table cliente").executeUpdate();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=1").executeUpdate();
        em.getTransaction().commit();
    }
    
}

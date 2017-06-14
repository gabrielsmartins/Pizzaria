/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.test.dao;

import br.ifsp.edu.pwe.pizzaria.dao.UsuarioDAO;
import br.ifsp.edu.pwe.pizzaria.model.Usuario;
import br.ifsp.edu.pwe.pizzaria.util.HibernateUtil;
import javax.persistence.EntityManager;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author home-pc
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioDAOTest {
    
    private static Usuario usuario;
    @BeforeClass
    public static void setUpClass() {
        UsuarioDAOTest.tearDownClass();
    }
    
    @Test
    public void testA_insereUsuario(){
        Usuario u = new Usuario();
        u.setLogin("gabriel@gmail.com");
        u.setNivel(2);
        u.setNome("Gabriel Martins");
        u.setSenha("12345");
        UsuarioDAOTest.usuario = new UsuarioDAO().insert(u);
    }
    
    @Test
    public void testB_buscaUsuario(){
        Usuario user = new UsuarioDAO().autentica(UsuarioDAOTest.usuario.getLogin(), UsuarioDAOTest.usuario.getSenha());
        assertEquals(UsuarioDAOTest.usuario.getNome(), user.getNome());
        assertEquals(UsuarioDAOTest.usuario.getLogin(), user.getLogin());
        assertEquals(UsuarioDAOTest.usuario.getSenha(), user.getSenha());
        assertEquals(UsuarioDAOTest.usuario.getNivel(), user.getNivel());
       
    }
    
    @Test
    public void testC_alteraUsuario(){
        Usuario u = new Usuario();
        u.setId(UsuarioDAOTest.usuario.getId());
        u.setLogin("gabrie.smartins@gmail.com");
        u.setNivel(2);
        u.setNome("Gabriel Martins");
        u.setSenha("12345");
        
        Usuario alterado = new UsuarioDAO().update(u);
        assertEquals(u.getLogin(), alterado.getLogin());
    }
    
    
    @Test
    public void testD_deletaUsuario(){
        new UsuarioDAO().delete(UsuarioDAOTest.usuario.getId());
    }
    
    @AfterClass
    public static void tearDownClass() {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=0").executeUpdate();
        em.createNativeQuery("truncate table usuario").executeUpdate();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=1").executeUpdate();
        em.getTransaction().commit();
    }
    
  
}

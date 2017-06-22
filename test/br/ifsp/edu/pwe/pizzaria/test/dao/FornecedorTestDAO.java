/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.test.dao;

import br.ifsp.edu.pwe.pizzaria.dao.FornecedorDAO;
import br.ifsp.edu.pwe.pizzaria.model.Fornecedor;
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
public class FornecedorTestDAO {
    
    private static Fornecedor fornecedor;
    
    
    @BeforeClass
    public static void setUpClass(){
        FornecedorTestDAO.tearDownClass();
    }
    
    @Test
    public void testA_insereFornecedor(){
        Fornecedor f = new Fornecedor();
        f.setAtivo(true);
        f.setNome("Fornecedor A");
        f.setCnpj(0505564564L);
        f.setEndereco("Rua A");
        f.setBairro("Bairro A");
        f.setComplemento("Residência");
        f.setCidade("Guarulhos");
        f.setEstado("SP");
        f.setNumero("73");
        f.setCep("07022250");
        f.setTelefone(11952050952L);
        FornecedorTestDAO.fornecedor = new FornecedorDAO().insert(f);
    }
    
    @Test
    public void testB_atualizaFornecedor(){
        Fornecedor f = new Fornecedor();
        f.setId(FornecedorTestDAO.fornecedor.getId());
        f.setAtivo(true);
        f.setCnpj(0064564464L);
        f.setNome("Fornecedor A");
        f.setEndereco("Rua B");
        f.setBairro("Bairro B");
        f.setComplemento("Residência");
        f.setCidade("Guarulhos");
        f.setEstado("SP");
        f.setNumero("73");
        f.setCep("07022250");
        f.setTelefone(11952050952L);
        new FornecedorDAO().update(f);
    }
    
    @Test
    public void testC_deletaFornecedor(){
        new FornecedorDAO().delete(FornecedorTestDAO.fornecedor.getId());
    }
    
    @AfterClass
    public static void tearDownClass(){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=0").executeUpdate();
        em.createNativeQuery("truncate table produto").executeUpdate();
        em.createNativeQuery("truncate table fornecedor").executeUpdate();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=1").executeUpdate();
        em.getTransaction().commit();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.test.dao;

import br.ifsp.edu.pwe.pizzaria.dao.FornecedorDAO;
import br.ifsp.edu.pwe.pizzaria.dao.ProdutoDAO;
import br.ifsp.edu.pwe.pizzaria.model.Bebida;
import br.ifsp.edu.pwe.pizzaria.model.Fornecedor;
import br.ifsp.edu.pwe.pizzaria.model.Ingrediente;
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
public class ProdutoDAOTest {

    private static Fornecedor fornecedor;
    private static Ingrediente ingrediente;
    private static Bebida bebida;

    @BeforeClass
    public static void setUpClass() {
       ProdutoDAOTest.tearDownClass();

        
        Fornecedor f = new Fornecedor();
        f.setAtivo(true);
        f.setNome("Fornecedor A");
        f.setCnpj(0505564564L);
        f.setEndereco("Rua A");
        f.setComplemento("Residência");
        f.setCidade("Guarulhos");
        f.setEstado("SP");
        f.setNumero("73");
        f.setCep("07022250");
        f.setTelefone(11952050952L);
        ProdutoDAOTest.fornecedor = new FornecedorDAO().insert(f);
    }

    @Test
    public void testA_insereProdutos() {
        Ingrediente i = new Ingrediente();
        i.setDescricao("Mussarela");
        i.setPreco(200.5);
        i.setQuantidade(5.00);
        i.setTamanhoVolume("1KG");
        i.setFornecedor(ProdutoDAOTest.fornecedor);
        ProdutoDAOTest.ingrediente = (Ingrediente)new ProdutoDAO().insert(i);
        
        
        Bebida b  = new Bebida();
        b.setDescricao("Coca-cola");
        b.setPreco(350.75);
        b.setQuantidade(100.00);
        b.setTamanhoVolume("350ml");
        b.setFornecedor(ProdutoDAOTest.fornecedor);
        ProdutoDAOTest.bebida = (Bebida) new ProdutoDAO().insert(b);
    }

    @Test
    public void testB_atualizaIngrediente() {
        Ingrediente i = new Ingrediente();
        i.setId(ProdutoDAOTest.ingrediente.getId());
        i.setDescricao("Mussarela");
        i.setPreco(200.5);
        i.setQuantidade(5.00);
        i.setTamanhoVolume("2KG");
        i.setFornecedor(ProdutoDAOTest.fornecedor);
        new ProdutoDAO().update(i);
        
        
        Bebida b  = new Bebida();
        b.setId(ProdutoDAOTest.bebida.getId());
        b.setDescricao("Coca-cola");
        b.setPreco(350.75);
        b.setQuantidade(100.00);
        b.setTamanhoVolume("2L");
        b.setFornecedor(ProdutoDAOTest.fornecedor);
        ProdutoDAOTest.bebida = (Bebida) new ProdutoDAO().update(b);
    }

    @Test
    public void testC_deletaIngrediente() {
        new ProdutoDAO().delete(ProdutoDAOTest.ingrediente.getId());
        new ProdutoDAO().delete(ProdutoDAOTest.bebida.getId());
    }

    @AfterClass
    public static void tearDownClass() {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=0").executeUpdate();
        em.createNativeQuery("truncate table produto").executeUpdate();
        em.createNativeQuery("truncate table fornecedor").executeUpdate();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=1").executeUpdate();
        em.getTransaction().commit();
    }
}

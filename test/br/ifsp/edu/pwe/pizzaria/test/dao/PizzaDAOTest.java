/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.test.dao;

import br.ifsp.edu.pwe.pizzaria.dao.FornecedorDAO;
import br.ifsp.edu.pwe.pizzaria.dao.IngredienteDAO;
import br.ifsp.edu.pwe.pizzaria.dao.PizzaDAO;
import br.ifsp.edu.pwe.pizzaria.model.Fornecedor;
import br.ifsp.edu.pwe.pizzaria.model.Ingrediente;
import br.ifsp.edu.pwe.pizzaria.model.Pizza;
import br.ifsp.edu.pwe.pizzaria.util.HibernateUtil;
import javax.persistence.EntityManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author home-pc
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PizzaDAOTest {
    
 
    private static Pizza pizza;
    private static Fornecedor bellapizza;
    
    @BeforeClass
    public static void setUpClass() {
        PizzaDAOTest.tearDownClass();
        
        Fornecedor forn = new Fornecedor();
        forn.setAtivo(true);
        forn.setNome("Fornecedor A");
        forn.setCnpj(3505564564L);
        forn.setEndereco("Rua A");
        forn.setComplemento("Residência");
        forn.setCidade("Guarulhos");
        forn.setEstado("SP");
        forn.setNumero("73");
        forn.setCep("07022250");
        forn.setTelefone(11952050952L);
        PizzaDAOTest.bellapizza = new FornecedorDAO().insert(forn);
    }
    
    @Test
    public void testA_inserePizza(){
        
        
        
        Fornecedor f = new Fornecedor();
        f.setAtivo(true);
        f.setNome("Fornecedor A");
        f.setCnpj(1505564564L);
        f.setEndereco("Rua A");
        f.setComplemento("Residência");
        f.setCidade("Guarulhos");
        f.setEstado("SP");
        f.setNumero("73");
        f.setCep("07022250");
        f.setTelefone(11952050952L);
        Fornecedor fornecedor = new FornecedorDAO().insert(f);
        
        
        Ingrediente ingrediente1 = new Ingrediente();
        ingrediente1.setDescricao("Mussarela");
        ingrediente1.setPreco(200.5);
        ingrediente1.setQuantidade(5.00);
        ingrediente1.setTamanhoVolume("1KG");
        ingrediente1.setFornecedor(fornecedor);

        
        Ingrediente ingrediente2 = new Ingrediente();
        ingrediente2.setDescricao("Calabresa");
        ingrediente2.setPreco(200.5);
        ingrediente2.setQuantidade(5.00);
        ingrediente2.setTamanhoVolume("1KG");
        ingrediente2.setFornecedor(fornecedor);

        
        
        new IngredienteDAO().insert(ingrediente1);
        new IngredienteDAO().insert(ingrediente2);
        
        Pizza p = new Pizza();
        p.setDescricao("Mussarela e Calabresa");
        p.setTamanhoVolume("M");
        p.setPreco(25.50);
        p.setFornecedor(bellapizza);
        
       
        p.adicionarIngrediente(ingrediente1, 0.5);
        p.adicionarIngrediente(ingrediente2, 0.2);
        
        
        PizzaDAOTest.pizza = new PizzaDAO().insert(p);
    }
    
    
     @Test
    public void testB_atualizaPizza(){
        Fornecedor f = new Fornecedor();
        f.setAtivo(true);
        f.setNome("Fornecedor X");
        f.setCnpj(2505564564L);
        f.setEndereco("Rua A");
        f.setComplemento("Residência");
        f.setCidade("Guarulhos");
        f.setEstado("SP");
        f.setNumero("73");
        f.setCep("07022250");
        f.setTelefone(11952050952L);
        Fornecedor fornecedor = new FornecedorDAO().insert(f);
        
        
        Ingrediente ingrediente1 = new Ingrediente();
        ingrediente1.setDescricao("Cebola");
        ingrediente1.setPreco(200.5);
        ingrediente1.setQuantidade(5.00);
        ingrediente1.setTamanhoVolume("1KG");
        ingrediente1.setFornecedor(fornecedor);

        
        Ingrediente ingrediente2 = new Ingrediente();
        ingrediente2.setDescricao("Mussarela");
        ingrediente2.setPreco(200.5);
        ingrediente2.setQuantidade(5.00);
        ingrediente2.setTamanhoVolume("1KG");
        ingrediente2.setFornecedor(fornecedor);

        
        
        new IngredienteDAO().insert(ingrediente1);
        new IngredienteDAO().insert(ingrediente2);
        
        Pizza p = new Pizza();
        p.setId(PizzaDAOTest.pizza.getId());
        p.setDescricao("Mussarela");
        p.setTamanhoVolume("G");
        p.setPreco(25.50);
        p.setFornecedor(PizzaDAOTest.bellapizza);
       
        p.adicionarIngrediente(ingrediente1, 0.5);
        p.adicionarIngrediente(ingrediente2, 0.2);
        
        
        PizzaDAOTest.pizza = new PizzaDAO().update(p);
    }
    
    
    public void testC_deletaPizza(){
        new PizzaDAO().delete(PizzaDAOTest.pizza.getId());
    }
    
    
    @AfterClass
    public static void tearDownClass() {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=0").executeUpdate();
        em.createNativeQuery("truncate table pizza_ingrediente").executeUpdate();
        em.createNativeQuery("truncate table produto").executeUpdate();
        em.createNativeQuery("truncate table fornecedor").executeUpdate();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=1").executeUpdate();
        em.getTransaction().commit();
    }
    

    
}

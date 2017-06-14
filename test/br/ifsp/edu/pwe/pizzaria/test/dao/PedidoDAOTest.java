/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.test.dao;

import br.ifsp.edu.pwe.pizzaria.dao.FornecedorDAO;
import br.ifsp.edu.pwe.pizzaria.dao.IngredienteDAO;
import br.ifsp.edu.pwe.pizzaria.dao.PedidoDAO;
import br.ifsp.edu.pwe.pizzaria.dao.PizzaDAO;
import br.ifsp.edu.pwe.pizzaria.model.Fornecedor;
import br.ifsp.edu.pwe.pizzaria.model.Ingrediente;
import br.ifsp.edu.pwe.pizzaria.model.PedidoLocal;
import br.ifsp.edu.pwe.pizzaria.model.Pizza;
import br.ifsp.edu.pwe.pizzaria.util.HibernateUtil;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author home-pc
 */
public class PedidoDAOTest {
    
    
    private static Pizza pizza;
    private static Fornecedor bellapizza;
   
    
    @BeforeClass
    public static void setUpClass() {
     
        PedidoDAOTest.tearDownClass();
        
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
        PedidoDAOTest.bellapizza = new FornecedorDAO().insert(forn);
    }
    
    @Test
    public void testA_inserePedido(){
        
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
        
        Pizza p1 = new Pizza();
        p1.setDescricao("Mussarela e Calabresa");
        p1.setTamanhoVolume("M");
        p1.setPreco(25.50);
        p1.setFornecedor(bellapizza);
        
       
        p1.adicionarIngrediente(ingrediente1, 0.5);
        p1.adicionarIngrediente(ingrediente2, 0.2);
        
        
        Pizza p2 = new Pizza();
        p2.setDescricao("Calabresa e Mussarela");
        p2.setTamanhoVolume("G");
        p2.setPreco(37.50);
        p2.setFornecedor(bellapizza);
        
       
        p2.adicionarIngrediente(ingrediente1, 0.3);
        p2.adicionarIngrediente(ingrediente2, 0.1);
        
        
        Pizza inserida1 = new PizzaDAO().insert(p1);
        Pizza inserida2 = new PizzaDAO().insert(p2);
       
        
        PedidoLocal pedidoLocal = new PedidoLocal();
        pedidoLocal.setNumeroMesa(1L);
        pedidoLocal.setData(Calendar.getInstance());
        pedidoLocal.adicionarItem(p1, 2.00);
        pedidoLocal.adicionarItem(p1, 3.00);
        pedidoLocal.adicionarItem(p2, 2.00);

        
        new PedidoDAO().insert(pedidoLocal);
    }
    
    @AfterClass
    public static void tearDownClass() {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=0").executeUpdate();
        em.createNativeQuery("truncate table pedido_detalhe").executeUpdate();
        em.createNativeQuery("truncate table pedido").executeUpdate();
        em.createNativeQuery("truncate table pizza_ingrediente").executeUpdate();
        em.createNativeQuery("truncate table produto").executeUpdate();
        em.createNativeQuery("truncate table fornecedor").executeUpdate();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=1").executeUpdate();
        em.getTransaction().commit();
    }

  
}

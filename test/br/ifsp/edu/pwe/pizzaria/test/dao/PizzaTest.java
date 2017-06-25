/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.test.dao;

import br.ifsp.edu.pwe.pizzaria.model.Fornecedor;
import br.ifsp.edu.pwe.pizzaria.model.Ingrediente;
import br.ifsp.edu.pwe.pizzaria.model.Pizza;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author HOME-PC
 */
public class PizzaTest {
    
   
    @Test
    public void testA_AdicionarIngredientes(){
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

        
        Ingrediente ingrediente1 = new Ingrediente();
        ingrediente1.setDescricao("Cebola");
        ingrediente1.setPreco(200.5);
        ingrediente1.setQuantidade(5.00);
        ingrediente1.setTamanhoVolume("1KG");
        ingrediente1.setFornecedor(f);

        
        Ingrediente ingrediente2 = new Ingrediente();
        ingrediente2.setDescricao("Mussarela");
        ingrediente2.setPreco(200.5);
        ingrediente2.setQuantidade(5.00);
        ingrediente2.setTamanhoVolume("1KG");
        ingrediente2.setFornecedor(f);

        
        
        Pizza pizza = new Pizza();
        pizza.setDescricao("Mussarela e Cebola");
        pizza.setPreco(30.75);
        pizza.setTamanhoVolume("M");
        pizza.adicionarIngrediente(ingrediente1, 5.00);
        pizza.adicionarIngrediente(ingrediente2, 2.00);
        pizza.adicionarIngrediente(ingrediente2, 2.00);
        assertEquals(2, pizza.getIngredientes().size());
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.model;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyJoinColumn;


/**
 *
 * @author HOME-PC
 */

@Entity
public class Pizza extends Produto {

    @ElementCollection(targetClass = Double.class)
    @JoinTable(name="pizza_ingrediente",
               joinColumns = @JoinColumn(name="pizza_id"))
    @Column(name="ingr_qntd")
    @MapKeyJoinColumn(name="ingr_id")
    private final Map<Ingrediente, Double> ingredientes = new HashMap<>();

    public Pizza() {

    }
  

    public Map<Ingrediente, Double> getIngredientes() {
        return ingredientes;
    }

    public void adicionarIngrediente(Ingrediente ingrediente, Double quantidade) {
        this.ingredientes.put(ingrediente, quantidade);
    }
    
    

    
}

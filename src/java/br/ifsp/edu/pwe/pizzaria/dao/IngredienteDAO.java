/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.dao;

import br.ifsp.edu.pwe.pizzaria.model.Ingrediente;

/**
 *
 * @author HOME-PC
 */
public class IngredienteDAO extends GenericDAO<Ingrediente, Long> {
    
    public IngredienteDAO(){
        super(Ingrediente.class);
    }
    
}

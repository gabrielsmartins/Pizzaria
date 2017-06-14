/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.dao;

import br.ifsp.edu.pwe.pizzaria.model.Cliente;

/**
 *
 * @author HOME-PC
 */
public class ClienteDAO extends GenericDAO<Cliente, Long> {
    
    public ClienteDAO(){
        super(Cliente.class);
    }
    
}

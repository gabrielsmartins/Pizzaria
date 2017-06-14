/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.dao;

import br.ifsp.edu.pwe.pizzaria.model.Pedido;

/**
 *
 * @author home-pc
 */
public class PedidoDAO extends GenericDAO<Pedido, Long> {
    
    public PedidoDAO(){
        super(Pedido.class);
    }
}

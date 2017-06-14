/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.dao;

import br.ifsp.edu.pwe.pizzaria.model.Pagamento;

/**
 *
 * @author HOME-PC
 */
public class PagamentoDAO extends GenericDAO<Pagamento, Long> {
    
    public PagamentoDAO(){
        super(Pagamento.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.dao;

import br.ifsp.edu.pwe.pizzaria.model.Notificacao;

/**
 *
 * @author HOME-PC
 */
public class NotificaoDAO extends GenericDAO<Notificacao, Long>{
    
    public NotificaoDAO(){
        super(Notificacao.class);
    }
    
}

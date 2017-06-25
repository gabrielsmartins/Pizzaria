/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.dao;

import br.ifsp.edu.pwe.pizzaria.model.Cliente;
import javax.persistence.NoResultException;

/**
 *
 * @author HOME-PC
 */
public class ClienteDAO extends GenericDAO<Cliente, Long> {
    
    public ClienteDAO(){
        super(Cliente.class);
    }
    
    public Cliente pesquisaClientePorTelefone(Long telefone){
         try {
            Cliente cliente = this.entityManager.createQuery("SELECT c from Cliente c where c.telefone = :telefone", Cliente.class)
                    .setParameter("telefone", Long.valueOf(telefone))
                    .getSingleResult();
            return cliente;
        } catch (NoResultException e) {
            return null;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author HOME-PC
 */

@Entity
public class PedidoLocal extends Pedido {
    
   @Column(name="ped_num_mesa") 
   private Long numeroMesa;
   @Column(name="ped_solic_pag") 
   private Boolean solicitadoPagamento;

    public Long getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Long numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Boolean isSolicitadoPagamento() {
        return solicitadoPagamento;
    }

    public void setSolicitadoPagamento(Boolean solicitadoPagamento) {
        this.solicitadoPagamento = solicitadoPagamento;
    }
   
   
    
    
    
}

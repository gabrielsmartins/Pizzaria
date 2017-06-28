/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

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
   @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY,cascade = javax.persistence.CascadeType.ALL)
   private List<Notificacao> notificacoes;
   

    public Long getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Long numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Boolean getSolicitadoPagamento() {
        return solicitadoPagamento;
    }

    public void setSolicitadoPagamento(Boolean solicitadoPagamento) {
        this.solicitadoPagamento = solicitadoPagamento;
    }

    public List<Notificacao> getNotificao() {
        return notificacoes;
    }

    public void setNotificao(List<Notificacao> notificao) {
        this.notificacoes = notificao;
    }
   
   
    
    
    
}

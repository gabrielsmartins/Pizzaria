/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.model;

import java.io.Serializable;

/**
 *
 * @author HOME-PC
 */
public class ComprovanteEntrega implements Serializable {
    
    private Long id;
    private PedidoTelefone pedidoTelefone;
    private String responsavel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PedidoTelefone getPedidoTelefone() {
        return pedidoTelefone;
    }

    public void setPedidoTelefone(PedidoTelefone pedidoTelefone) {
        this.pedidoTelefone = pedidoTelefone;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    
    
    
}

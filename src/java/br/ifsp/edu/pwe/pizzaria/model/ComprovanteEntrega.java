/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author HOME-PC
 */

@Entity
@Table(name="comprovante_entrega")
public class ComprovanteEntrega implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comp_id")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="comp_ped_id")
    private PedidoTelefone pedidoTelefone;
    @Column(name="com_resp")
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

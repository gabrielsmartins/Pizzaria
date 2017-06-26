/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author HOME-PC
 */

@Entity
@Table(name="pedido")
public abstract class Pedido implements Serializable {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ped_id")
    private Long id;
    @Column(name="ped_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data = Calendar.getInstance();
    @ElementCollection(targetClass = Double.class)
    @JoinTable(name="pedido_detalhe",
               joinColumns = @JoinColumn(name="ped_id"))
    @Column(name="prod_qntd")
    @MapKeyJoinColumn(name="prod_id")
    private final Map<Produto, Double> itens = new HashMap<>();
    @Column(name="ped_total")
    private Double total = 0.00;

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Map<Produto, Double> getItens() {
        return itens;
    }

    public void adicionarItem(Produto produto,Double quantidade) {
        itens.put(produto, quantidade);
        this.atualizaTotal();
          
    }

    public Double getTotal() {
        return total;
    }

   private void atualizaTotal(){
       itens.entrySet().forEach((item) -> {
           this.total+=item.getKey().preco*item.getValue();
        });
          
   }
    
}

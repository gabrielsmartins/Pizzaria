/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author HOME-PC
 */

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cli_id")
    private Long id;
    @Column(name="cli_nome")
    private String nome;
    @Column(name="cli_end")
    private String endereco;
    @Column(name="cli_compl")
    private String complemento;
    @Column(name="cli_cid")
    private String cidade;
    @Column(name="cli_est")
    private String estado;
    @Column(name="cli_num")
    private String numero;
    @Column(name="cli_bair")
    private String bairro;
    @Column(name="cli_cep")
    private String cep;
    @Column(name="cli_tel")
    private Long telefone;

   
    
    public Cliente(){
        
    }
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco.toUpperCase();
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento.toUpperCase();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade.toUpperCase();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado.toUpperCase();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    
    
    
}

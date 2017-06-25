/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.model;

import br.ifsp.edu.pwe.pizzaria.util.SampleEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author HOME-PC
 */

@Entity
@Table(name="fornecedor")
public class Fornecedor implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="forn_id")
    private Long id;
    @Column(name="forn_cnpj")
    private Long cnpj;
    @Column(name="forn_nome")
    private String nome;
    @Column(name="forn_end")
    private String endereco;
    @Column(name="forn_compl")
    private String complemento;
    @Column(name="forn_cid")
    private String cidade;
    @Column(name="forn_est")
    private String estado;
    @Column(name="forn_num")
    private String numero;
    @Column(name="forn_bair")
    private String bairro;
    @Column(name="forn_cep")
    private String cep;
    @Column(name="forn_tel")
    private Long telefone;
    @Column(name="forn_ativo")
    private Boolean ativo;
   @OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Produto> produtos;
    
    public Fornecedor(){
        this.produtos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
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
        this.numero = numero.toUpperCase();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Produto> getIngredientes() {
        return produtos;
    }

    public void setIngredientes(List<Produto> ingredientes) {
        this.produtos = ingredientes;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.bean;

import br.ifsp.edu.pwe.pizzaria.dao.PagamentoDAO;
import br.ifsp.edu.pwe.pizzaria.dao.PedidoLocalDAO;
import br.ifsp.edu.pwe.pizzaria.model.Pagamento;
import br.ifsp.edu.pwe.pizzaria.model.PedidoLocal;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aluno
 */

@ManagedBean
public class PagamentoBean {
    private final PagamentoDAO pagamentoDAO = new PagamentoDAO();
    private final PedidoLocalDAO pedidoDAO = new PedidoLocalDAO();
    private Pagamento pagamento = new Pagamento();
    private Long idPedido;

    
    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
    
    
    
    public void registrar(){
        this.pagamento.setPedido(this.pedidoDAO.find(idPedido));
        FacesContext context = FacesContext.getCurrentInstance();
        this.pagamentoDAO.insert(pagamento);
        context.addMessage(null, new FacesMessage("Sucesso","Dados Salvos com Sucesso"));
        this.pagamento = new Pagamento();
    }
    
     public List<Pagamento> getPagamentos(){
        return this.pagamentoDAO.getList();
    }
     
     public List<PedidoLocal> getPedidos(){
         return this.pedidoDAO.getList();
     }
}

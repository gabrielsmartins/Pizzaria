/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.bean;

import br.ifsp.edu.pwe.pizzaria.dao.NotificaoDAO;
import br.ifsp.edu.pwe.pizzaria.dao.PedidoLocalDAO;
import br.ifsp.edu.pwe.pizzaria.model.Notificacao;
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
public class NotificacaoBean {
    
    private final PedidoLocalDAO pedidoDAO = new PedidoLocalDAO();
    private final NotificaoDAO notificaoDAO = new NotificaoDAO();
    private Notificacao notificacao = new Notificacao();
    private Long idPedido;
    

    
    public Notificacao getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
    
    
    
    
    public void emitir(){
        this.notificacao.setPedido(this.pedidoDAO.find(idPedido));
        FacesContext context = FacesContext.getCurrentInstance();
        this.notificaoDAO.insert(notificacao);
        context.addMessage(null, new FacesMessage("Sucesso","Dados Salvos com Sucesso"));
        this.notificacao = new Notificacao();
    }
    
    public List<Notificacao> getNotificacoes(){
        return this.notificaoDAO.getList();
    }
    
    public List<PedidoLocal> getPedidos(){
        return this.pedidoDAO.getList();
    }
    
}

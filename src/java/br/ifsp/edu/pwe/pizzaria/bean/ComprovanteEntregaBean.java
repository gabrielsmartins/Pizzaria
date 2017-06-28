/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.bean;

import br.ifsp.edu.pwe.pizzaria.dao.ComprovanteEntregaDAO;
import br.ifsp.edu.pwe.pizzaria.dao.PedidoTelefoneDAO;
import br.ifsp.edu.pwe.pizzaria.model.ComprovanteEntrega;
import br.ifsp.edu.pwe.pizzaria.model.Pagamento;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aluno
 */

@ManagedBean
public class ComprovanteEntregaBean {
    
    private final ComprovanteEntregaDAO comprovanteEntregaDAO = new ComprovanteEntregaDAO();
    private final PedidoTelefoneDAO pedidoDAO = new PedidoTelefoneDAO();
    private ComprovanteEntrega comprovante = new ComprovanteEntrega();
    private Long idComprovante;
    
    

    public ComprovanteEntrega getComprovante() {
        return comprovante;
    }

    public void setComprovante(ComprovanteEntrega comprovante) {
        this.comprovante = comprovante;
    }

    public Long getIdComprovante() {
        return idComprovante;
    }

    public void setIdComprovante(Long idComprovante) {
        this.idComprovante = idComprovante;
    }
    
    
    
    public void registrar(){
        this.comprovante.setPedidoTelefone(this.pedidoDAO.find(idComprovante));
        FacesContext context = FacesContext.getCurrentInstance();
        this.comprovanteEntregaDAO.insert(comprovante);
        context.addMessage(null, new FacesMessage("Sucesso","Dados Salvos com Sucesso"));
        this.comprovante = new ComprovanteEntrega();
    }
    
    
    
}

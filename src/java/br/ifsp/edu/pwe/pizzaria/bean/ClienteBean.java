package br.ifsp.edu.pwe.pizzaria.bean;

import br.ifsp.edu.pwe.pizzaria.dao.ClienteDAO;
import br.ifsp.edu.pwe.pizzaria.model.Cliente;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aluno
 */

@ManagedBean
@SessionScoped
public class ClienteBean {
    
    private ClienteDAO clienteDAO = new ClienteDAO();
    private Cliente cliente = new Cliente();

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void salvar(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(this.cliente.getId() == null)
            this.clienteDAO.insert(cliente);
        else
            this.clienteDAO.update(cliente);
        context.addMessage(null , new FacesMessage("Sucesso","Dados Salvos com Sucesso"));
        this.cliente = new Cliente();
    }
    
    public void editar(Long id){
        FacesContext context = FacesContext.getCurrentInstance();
        this.cliente = this.clienteDAO.find(id);
    }
    
    public void excluir(Long id){
        FacesContext context = FacesContext.getCurrentInstance();
        this.clienteDAO.delete(id);
        context.addMessage(null , new FacesMessage("Sucesso","Exclusão Realizada com Sucesso"));
        //return "/fornecedor";
    }
    
    public List<Cliente> getClientes(){
        return this.clienteDAO.getList();
    }
    
}

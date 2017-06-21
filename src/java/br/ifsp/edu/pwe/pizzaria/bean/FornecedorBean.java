
package br.ifsp.edu.pwe.pizzaria.bean;

import br.ifsp.edu.pwe.pizzaria.dao.FornecedorDAO;
import br.ifsp.edu.pwe.pizzaria.model.Fornecedor;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author HOME-PC
 */

@ManagedBean
@SessionScoped
public class FornecedorBean {
    
    private final FornecedorDAO fornecedorDAO = new FornecedorDAO();
    private Fornecedor fornecedor = new Fornecedor();

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public void salvar(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(this.fornecedor.getId() == null)
            this.fornecedorDAO.insert(fornecedor);
        else
            this.fornecedorDAO.update(fornecedor);
        context.addMessage(null , new FacesMessage("Sucesso","Dados Salvos com Sucesso"));
        this.fornecedor = new Fornecedor();
    }
    
    public void editar(Long id){
        FacesContext context = FacesContext.getCurrentInstance();
        this.fornecedor = this.fornecedorDAO.find(id);
    }
    
    public void excluir(Long id){
        FacesContext context = FacesContext.getCurrentInstance();
        this.fornecedorDAO.delete(id);
        context.addMessage(null , new FacesMessage("Sucesso","Exclusão Realizada com Sucesso"));
        //return "/fornecedor";
    }
    
    public List<Fornecedor> getFornecedores(){
        return this.fornecedorDAO.getList();
    }
}

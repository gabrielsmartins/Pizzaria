
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
    
    public void cadastrar(){
        FacesContext context = FacesContext.getCurrentInstance();
        this.fornecedorDAO.insert(fornecedor);
        context.addMessage(null , new FacesMessage("Sucesso","Cadastro Realizado com Sucesso"));
    }
    
    public List<Fornecedor> getFornecedores(){
        return this.fornecedorDAO.getList();
    }
}

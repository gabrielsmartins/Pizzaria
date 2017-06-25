package br.ifsp.edu.pwe.pizzaria.bean;

import br.ifsp.edu.pwe.pizzaria.dao.FornecedorDAO;
import br.ifsp.edu.pwe.pizzaria.dao.IngredienteDAO;
import br.ifsp.edu.pwe.pizzaria.model.Fornecedor;
import br.ifsp.edu.pwe.pizzaria.model.Ingrediente;
import br.ifsp.edu.pwe.pizzaria.model.Produto;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aluno
 */
@ManagedBean
public class IngredienteBean {

    private final IngredienteDAO ingredienteDAO = new IngredienteDAO();
    private final FornecedorDAO fornecedorDAO = new FornecedorDAO();
    private Long idForn;
    private Ingrediente ingrediente = new Ingrediente();

    public Long getIdForn() {
        return idForn;
    }

    public void setIdForn(Long idForn) {
        this.idForn = idForn;
    }

    public Produto getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public void salvar() {
        Fornecedor fornecedor = this.fornecedorDAO.find(idForn);
        this.ingrediente.setFornecedor(fornecedor);
        FacesContext context = FacesContext.getCurrentInstance();
        if (this.ingrediente.getId() == null) {
            this.ingredienteDAO.insert(ingrediente);
        } else {
            this.ingredienteDAO.update(ingrediente);
        }
        context.addMessage(null, new FacesMessage("Sucesso", "Dados Salvos com Sucesso"));
        this.ingrediente = new Ingrediente();
    }

    public void editar(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        this.ingrediente = this.ingredienteDAO.find(id);
    }

    public void excluir(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        this.ingredienteDAO.delete(id);
        context.addMessage(null, new FacesMessage("Sucesso", "Exclusão Realizada com Sucesso"));
    }

    public List<Ingrediente> getIngredientes() {
        return this.ingredienteDAO.getList();
    }

    public List<Fornecedor> getFornecedores() {
        return this.fornecedorDAO.getList();
    }

}

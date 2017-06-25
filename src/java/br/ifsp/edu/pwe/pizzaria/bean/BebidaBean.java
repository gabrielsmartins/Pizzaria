package br.ifsp.edu.pwe.pizzaria.bean;

import br.ifsp.edu.pwe.pizzaria.dao.BebidaDAO;
import br.ifsp.edu.pwe.pizzaria.dao.FornecedorDAO;
import br.ifsp.edu.pwe.pizzaria.model.Bebida;
import br.ifsp.edu.pwe.pizzaria.model.Fornecedor;
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
public class BebidaBean {

    private final BebidaDAO bebidaDAO = new BebidaDAO();
    private final FornecedorDAO fornecedorDAO = new FornecedorDAO();
    private Long idForn;
    private Bebida bebida = new Bebida();
    private Bebida selectedBebida = new Bebida();

    public Long getIdForn() {
        return idForn;
    }

    public void setIdForn(Long idForn) {
        this.idForn = idForn;
    }

    public Produto getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public Bebida getSelectedBebida() {
        return selectedBebida;
    }

    public void setSelectedBebida(Bebida selectedBebida) {
        this.selectedBebida = selectedBebida;
    }
    
    

    public void salvar() {
        Fornecedor fornecedor = this.fornecedorDAO.find(idForn);
        this.bebida.setFornecedor(fornecedor);
        FacesContext context = FacesContext.getCurrentInstance();
        if (this.bebida.getId() == null) {
            this.bebidaDAO.insert(bebida);
        } else {
            this.bebidaDAO.update(bebida);
        }
        context.addMessage(null, new FacesMessage("Sucesso", "Dados Salvos com Sucesso"));
        this.bebida = new Bebida();
    }

    public void editar(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        this.bebida = this.bebidaDAO.find(id);
    }

    public void excluir(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        this.bebidaDAO.delete(id);
        context.addMessage(null, new FacesMessage("Sucesso", "Exclusão Realizada com Sucesso"));
    }

    public List<Bebida> getBebidas() {
        return this.bebidaDAO.getList();
    }

    public List<Fornecedor> getFornecedores() {
        return this.fornecedorDAO.getList();
    }

}

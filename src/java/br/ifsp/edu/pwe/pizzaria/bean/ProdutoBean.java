package br.ifsp.edu.pwe.pizzaria.bean;


import br.ifsp.edu.pwe.pizzaria.dao.ProdutoDAO;
import br.ifsp.edu.pwe.pizzaria.model.Produto;
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
public class ProdutoBean {
    
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private Produto produto = new Produto();

    public ProdutoBean() {
    }

    public ProdutoDAO getProdutoDAO() {
        return produtoDAO;
    }

    public void setProdutoDAO(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    
    public void salvar(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(this.produto.getId() == null)
            this.produtoDAO.insert(produto);
        else
            this.produtoDAO.update(produto);
        context.addMessage(null , new FacesMessage("Sucesso","Dados Salvos com Sucesso"));
        this.produto = new Produto();
    }
    
    public void editar(Long id){
        FacesContext context = FacesContext.getCurrentInstance();
        this.produto = this.produtoDAO.find(id);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void excluir(Long id){
        FacesContext context = FacesContext.getCurrentInstance();
        this.produtoDAO.delete(id);
        context.addMessage(null , new FacesMessage("Sucesso","Exclusão Realizada com Sucesso"));
        //return "/fornecedor";
    }
    
    public List<Produto> getProdutos(){
        return this.produtoDAO.getList();
    }
    
}


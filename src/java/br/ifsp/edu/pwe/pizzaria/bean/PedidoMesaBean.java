package br.ifsp.edu.pwe.pizzaria.bean;

import br.ifsp.edu.pwe.pizzaria.dao.BebidaDAO;
import br.ifsp.edu.pwe.pizzaria.dao.PedidoDAO;
import br.ifsp.edu.pwe.pizzaria.dao.PizzaDAO;
import br.ifsp.edu.pwe.pizzaria.dao.ProdutoDAO;
import br.ifsp.edu.pwe.pizzaria.model.Bebida;
import br.ifsp.edu.pwe.pizzaria.model.PedidoLocal;
import br.ifsp.edu.pwe.pizzaria.model.Pizza;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author HOME-PC
 */
@ManagedBean
@ViewScoped
public class PedidoMesaBean {

    private final PedidoDAO pedidoDAO = new PedidoDAO();
    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private final PizzaDAO pizzaDAO = new PizzaDAO();
    private final BebidaDAO bebidaDAO = new BebidaDAO();
    private PedidoLocal pedido = new PedidoLocal();
    private PedidoLocal selectedPedidoLocal = new PedidoLocal();
    private Long idBebida, idPizza;
    private Double qntdPizza, qntdBebida;

    public PedidoLocal getPedido() {
        return pedido;
    }

    public void setPedido(PedidoLocal pedido) {
        this.pedido = pedido;
    }

    public PedidoLocal getSelectedPedidoLocal() {
        return selectedPedidoLocal;
    }

    public void setSelectedPedidoLocal(PedidoLocal selectedPedidoLocal) {
        this.selectedPedidoLocal = selectedPedidoLocal;
    }

    
    
    public Long getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(Long idBebida) {
        this.idBebida = idBebida;
    }

    public Long getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(Long idPizza) {
        this.idPizza = idPizza;
    }

    public Double getQntdPizza() {
        return qntdPizza;
    }

    public void setQntdPizza(Double qntdPizza) {
        this.qntdPizza = qntdPizza;
    }

    public Double getQntdBebida() {
        return qntdBebida;
    }

    public void setQntdBebida(Double qntdBebida) {
        this.qntdBebida = qntdBebida;
    }

    public void adicionarPizza() {
        Pizza pizza = this.pizzaDAO.find(idPizza);
        this.pedido.adicionarItem(pizza, qntdPizza);

    }

    public void adicionarBebida() {
        Bebida bebida = this.bebidaDAO.find(idBebida);
        this.pedido.adicionarItem(bebida, qntdBebida);
    }

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (this.pedido.getId() == null) {
            this.pedidoDAO.insert(pedido);
        } else {
            this.pedidoDAO.update(pedido);
        }
        context.addMessage(null, new FacesMessage("Sucesso", "Dados Salvos com Sucesso"));
        this.pedido = new PedidoLocal();
    }

    public void editar(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        this.pedido = (PedidoLocal) this.pedidoDAO.find(id);
    }

    public void excluir(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        this.pedidoDAO.delete(id);
        context.addMessage(null, new FacesMessage("Sucesso", "Exclusão Realizada com Sucesso"));
    }

    public List<PedidoLocal> getPedidos() {
        return (List<PedidoLocal>) (List) this.pedidoDAO.getList();
    }

    public List<Pizza> getPizzas() {
        return this.pizzaDAO.getList();
    }

    public List<Bebida> getBebidas() {
        return this.bebidaDAO.getList();
    }

}

package br.ifsp.edu.pwe.pizzaria.bean;

import br.ifsp.edu.pwe.pizzaria.dao.BebidaDAO;
import br.ifsp.edu.pwe.pizzaria.dao.PedidoLocalDAO;
import br.ifsp.edu.pwe.pizzaria.dao.PizzaDAO;
import br.ifsp.edu.pwe.pizzaria.model.Bebida;
import br.ifsp.edu.pwe.pizzaria.model.PedidoLocal;
import br.ifsp.edu.pwe.pizzaria.model.Pizza;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author HOME-PC
 */
@ManagedBean
public class PedidoMesaBean {

    private final PedidoLocalDAO pedidoLocalDAO = new PedidoLocalDAO();
    private final PizzaDAO pizzaDAO = new PizzaDAO();
    private final BebidaDAO bebidaDAO = new BebidaDAO();
    private PedidoLocal pedidoLocal = new PedidoLocal();
    private PedidoLocal selectedPedidoLocal = new PedidoLocal();
    private Long idBebida, idPizza;
    private Double qntdPizza, qntdBebida;

    public PedidoLocal getPedido() {
        return pedidoLocal;
    }

    public void setPedido(PedidoLocal pedido) {
        this.pedidoLocal = pedido;
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
        this.pedidoLocal.adicionarItem(pizza, qntdPizza);

    }

    public void adicionarBebida() {
        Bebida bebida = this.bebidaDAO.find(idBebida);
        this.pedidoLocal.adicionarItem(bebida, qntdBebida);
 
    }

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (this.pedidoLocal.getId() == null) {
            this.pedidoLocalDAO.insert(pedidoLocal);
        } else {
            this.pedidoLocalDAO.update(pedidoLocal);
        }
        context.addMessage(null, new FacesMessage("Sucesso", "Dados Salvos com Sucesso"));
        this.pedidoLocal = new PedidoLocal();
    }

    public void editar(Long id) {
        this.pedidoLocal =  this.pedidoLocalDAO.find(id);
    }

    public void excluir(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        this.pedidoLocalDAO.delete(id);
        context.addMessage(null, new FacesMessage("Sucesso", "Exclusão Realizada com Sucesso"));
    }

    public List<PedidoLocal> getPedidos() {
        return this.pedidoLocalDAO.getList();
    }

    public List<Pizza> getPizzas() {
        return this.pizzaDAO.getList();
    }

    public List<Bebida> getBebidas() {
        return this.bebidaDAO.getList();
    }

}

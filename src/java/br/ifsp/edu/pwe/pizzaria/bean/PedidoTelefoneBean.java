package br.ifsp.edu.pwe.pizzaria.bean;

import br.ifsp.edu.pwe.pizzaria.dao.BebidaDAO;
import br.ifsp.edu.pwe.pizzaria.dao.ClienteDAO;
import br.ifsp.edu.pwe.pizzaria.dao.PedidoTelefoneDAO;
import br.ifsp.edu.pwe.pizzaria.dao.PizzaDAO;
import br.ifsp.edu.pwe.pizzaria.model.Bebida;
import br.ifsp.edu.pwe.pizzaria.model.PedidoTelefone;
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
public class PedidoTelefoneBean {

    private final PedidoTelefoneDAO pedidoTelefoneDAO = new PedidoTelefoneDAO();
    private final PizzaDAO pizzaDAO = new PizzaDAO();
    private final BebidaDAO bebidaDAO = new BebidaDAO();
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private PedidoTelefone pedido = new PedidoTelefone();
    private PedidoTelefone selectedPedidoTelefone = new PedidoTelefone();
    private Long idBebida, idPizza;
    private Double qntdPizza, qntdBebida;
    private Long telefone;

    public PedidoTelefone getPedido() {
        return pedido;
    }

    public void setPedido(PedidoTelefone pedido) {
        this.pedido = pedido;
    }

    public PedidoTelefone getSelectedPedidoTelefone() {
        return selectedPedidoTelefone;
    }

    public void setSelectedPedidoTelefone(PedidoTelefone selectedPedidoTelefone) {
        this.selectedPedidoTelefone = selectedPedidoTelefone;
    }

    
    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }
    
    public void pesquisarClientePorTelefone(){
        try{
             this.pedido.setCliente(this.clienteDAO.pesquisaClientePorTelefone(Long.valueOf(telefone.toString())));
        }catch(Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage("Atenção", "Cliente não Cadastrado"));
        }
       
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
            this.pedidoTelefoneDAO.insert(pedido);
        } else {
            this.pedidoTelefoneDAO.update(pedido);
        }
        context.addMessage(null, new FacesMessage("Sucesso", "Dados Salvos com Sucesso"));
        this.pedido = new PedidoTelefone();
    }

    public void editar(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        this.pedido = (PedidoTelefone) this.pedidoTelefoneDAO.find(id);
    }

    public void excluir(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        this.pedidoTelefoneDAO.delete(id);
        context.addMessage(null, new FacesMessage("Sucesso", "Exclusão Realizada com Sucesso"));
    }

    public List<PedidoTelefone> getPedidos() {
        return this.pedidoTelefoneDAO.getList();
    }

    public List<Pizza> getPizzas() {
        return this.pizzaDAO.getList();
    }

    public List<Bebida> getBebidas() {
        return this.bebidaDAO.getList();
    }

}

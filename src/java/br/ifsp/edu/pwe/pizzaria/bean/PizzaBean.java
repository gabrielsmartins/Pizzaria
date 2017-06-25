
package br.ifsp.edu.pwe.pizzaria.bean;

import br.ifsp.edu.pwe.pizzaria.dao.IngredienteDAO;
import br.ifsp.edu.pwe.pizzaria.dao.PizzaDAO;
import br.ifsp.edu.pwe.pizzaria.model.Ingrediente;
import br.ifsp.edu.pwe.pizzaria.model.Pizza;
import java.util.List;
import javafx.event.ActionEvent;
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
public class PizzaBean {
    
    private final PizzaDAO pizzaDAO = new PizzaDAO();
    private final IngredienteDAO ingredienteDAO = new IngredienteDAO();
    private Pizza pizza = new Pizza();
    private Pizza selectedPizza = new Pizza();
    private Long idIngr;
    private Double qntdIngr;
    
    

    
    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = new Pizza();
    }

    public Pizza getSelectedPizza() {
        return selectedPizza;
    }

    public void setSelectedPizza(Pizza selectedPizza) {
        this.selectedPizza = selectedPizza;
    }

    
    public Long getIdIngr() {
        return idIngr;
    }

    public void setIdIngr(Long idIngr) {
        this.idIngr = idIngr;
    }

    public Double getQntdIngr() {
        return qntdIngr;
    }

    public void setQntdIngr(Double qntdIngr) {
        this.qntdIngr = qntdIngr;
    }
    
    
    
    
    public void adicionarIngrediente(){
        Ingrediente ingrediente = this.ingredienteDAO.find(idIngr);
        this.pizza.adicionarIngrediente(ingrediente, qntdIngr);
    }
    
    
    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (this.pizza.getId() == null) {
            this.pizzaDAO.insert(pizza);
        } else {
            this.pizzaDAO.update(pizza);
        }
        context.addMessage(null, new FacesMessage("Sucesso", "Dados Salvos com Sucesso"));
        this.pizza = new Pizza();
    }

    public void editar(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        this.pizza = this.pizzaDAO.find(id);
    }

    public void excluir(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        this.pizzaDAO.delete(id);
        context.addMessage(null, new FacesMessage("Sucesso", "Exclusão Realizada com Sucesso"));
    }

    public List<Pizza> getPizzas() {
        return this.pizzaDAO.getList();
    }

    public List<Ingrediente> getIngredientes() {
        return this.ingredienteDAO.getList();
    }
    
}

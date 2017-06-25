
package br.ifsp.edu.pwe.pizzaria.bean;

import br.ifsp.edu.pwe.pizzaria.dao.IngredienteDAO;
import br.ifsp.edu.pwe.pizzaria.dao.PizzaDAO;
import br.ifsp.edu.pwe.pizzaria.model.Bebida;
import br.ifsp.edu.pwe.pizzaria.model.Ingrediente;
import br.ifsp.edu.pwe.pizzaria.model.Pizza;
import br.ifsp.edu.pwe.pizzaria.model.Produto;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author HOME-PC
 */

@ManagedBean
public class PizzaBean {
    
    private final PizzaDAO pizzaDAO = new PizzaDAO();
    private final IngredienteDAO ingredienteDAO = new IngredienteDAO();
    private Pizza pizza = new Pizza();

    public Produto getPizza() {
        return pizza;
    }

    public void setPizza(Produto pizza) {
        this.pizza = new Pizza();
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

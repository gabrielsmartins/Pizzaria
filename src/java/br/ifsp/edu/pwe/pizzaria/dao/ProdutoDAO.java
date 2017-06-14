package br.ifsp.edu.pwe.pizzaria.dao;

import br.ifsp.edu.pwe.pizzaria.model.Produto;

/**
 *
 * @author home-pc
 */
public class ProdutoDAO extends GenericDAO<Produto, Long>{
    
    public ProdutoDAO(){
        super(Produto.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.dao;

import br.ifsp.edu.pwe.pizzaria.model.Usuario;
import javax.persistence.NoResultException;

/**
 *
 * @author home-pc
 */
public class UsuarioDAO extends GenericDAO<Usuario, Long> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Usuario autentica(String login, String senha) {
        try {
            Usuario usuario = this.entityManager.createQuery("SELECT u from Usuario u where u.login = :login and u.senha = :senha", Usuario.class)
                    .setParameter("login", login)
                    .setParameter("senha", senha)
                    .getSingleResult();
            return usuario;
        } catch (NoResultException e) {
            return null;
        }

    }

}

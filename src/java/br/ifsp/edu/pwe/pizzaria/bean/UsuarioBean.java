/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.edu.pwe.pizzaria.bean;

import br.ifsp.edu.pwe.pizzaria.dao.UsuarioDAO;
import br.ifsp.edu.pwe.pizzaria.model.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HOME-PC
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

   private Usuario usuario = new Usuario();
   private UsuarioDAO usuarioDAO = new UsuarioDAO();

   
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
 

    public String autentica() {
         usuario = usuarioDAO.autentica(this.usuario.getLogin(), this.usuario.getSenha());

        if (usuario == null) {
            usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou Senha Não Encontrados!",
                            "Autenticação Falhou"));
            return null;
            
        } else {
            
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            HttpSession session = (HttpSession) context.getSession(false);
            session.setAttribute("usuarioLogado", usuario);
            return "/main";
        }
    }

  
    
}

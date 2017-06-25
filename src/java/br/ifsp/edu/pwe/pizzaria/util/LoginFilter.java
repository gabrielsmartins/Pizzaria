/*package br.ifsp.edu.pwe.pizzaria.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "Login", urlPatterns = {"*.jsf"})
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {

            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession session = reqt.getSession(false);

            String reqURI = reqt.getRequestURI();
            if ((session != null && session.getAttribute("usuarioLogado") != null)) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect("index.jsf");
            }
        } catch (IOException | ServletException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void destroy() {

    }
}*/
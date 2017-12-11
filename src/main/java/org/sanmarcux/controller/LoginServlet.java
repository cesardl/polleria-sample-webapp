/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.controller;

import org.sanmarcux.domain.Usuario;
import org.sanmarcux.service.UsuarioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author root
 */
public class LoginServlet extends HttpServlet {

    private UsuarioService usuarioService;

    public LoginServlet() {
        usuarioService = new UsuarioService();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("login") != null) {
            Usuario u = new Usuario(request.getParameter("j_user"), request.getParameter("j_passwd"));
            if ((u = usuarioService.validarUsuario(u)) != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("admin_visible", true);
                session.setAttribute("usuario", u);
            } else {
                request.setAttribute("admin_visible", false);
            }
        } else {
            HttpSession session = request.getSession();
            Enumeration atributos = session.getAttributeNames();
            while (atributos.hasMoreElements()) {
                session.removeAttribute(atributos.nextElement().toString());
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("bienvenido.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

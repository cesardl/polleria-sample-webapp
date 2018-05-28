/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.controller;

import org.sanmarcux.domain.Usuario;
import org.sanmarcux.service.UsuarioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author Cesardl
 */
@WebServlet(name = "LoginServlet", value = "/login.servlet")
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
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String password = request.getParameter("j_passwd");
//        try {
//            String x = request.getParameter("j_passwd");
//            System.out.println(x);
//            java.security.MessageDigest d = java.security.MessageDigest.getInstance("SHA-1");
//            d.reset();
//            d.update(x.getBytes());
//            password = new String(Base64.getEncoder().encode(d.digest()));
//        } catch (NoSuchAlgorithmException e) {
//            password = "";
//            e.printStackTrace();
//        }

        if (request.getParameter("login") != null) {
            Usuario u = usuarioService.validarUsuario(request.getParameter("j_user"), password);
            if (u != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("admin_visible", true);
                session.setAttribute("usuario", u);
            } else {
                request.setAttribute("admin_visible", false);
            }
        } else {
            HttpSession session = request.getSession();
            Enumeration attributes = session.getAttributeNames();
            while (attributes.hasMoreElements()) {
                session.removeAttribute(attributes.nextElement().toString());
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("bienvenido.jsp");
        rd.forward(request, response);
    }

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
    }
}

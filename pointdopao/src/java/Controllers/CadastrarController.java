/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.UsuarioDao;
import Models.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bcovies
 */
@WebServlet(name = "CadastrarController", urlPatterns = {"/cadastrar"})
public class CadastrarController extends HttpServlet {

    private static String NOVOUSUARIO = "/entrar.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario();

        usuario.setTipo(1);
        usuario.setNome(request.getParameter("nomeForm"));
        usuario.setSobrenome(request.getParameter("sobrenomeForm"));
        usuario.setEmail(request.getParameter("emailForm"));
        usuario.setSenha(request.getParameter("senhaForm"));
//        System.out.println(request.getParameter("nomeForm") + request.getParameter("sobrenomeForm") +  request.getParameter("emailForm") +  request.getParameter("senhaForm") );

        try {
            usuarioDao.insertUser(usuario);
            String forward = NOVOUSUARIO;
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

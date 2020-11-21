/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.UsuarioDao;
import Models.Usuario;
import java.io.IOException;
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
        usuario.setNome(request.getParameter("nomeForm").toUpperCase());
        usuario.setSobrenome(request.getParameter("sobrenomeForm").toUpperCase());
        usuario.setEmail(request.getParameter("emailForm").toUpperCase());
        usuario.setSenha(request.getParameter("senhaForm"));

        try {
            usuarioDao.insertUser(usuario);

            //System.out.println("\nCADASTRARCONTROLLER:\n" + "Email: " + usuario.getEmail() + " Nome:" + usuario.getNome() + " Sobrenome:" + usuario.getSobrenome() + " Senha:" + usuario.getSenha());

            boolean success = true;
            request.setAttribute("success", success);

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

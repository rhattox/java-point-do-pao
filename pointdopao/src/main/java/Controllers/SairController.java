/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author bcovies
 */
@WebServlet(name = "SairController", urlPatterns = {"/sair"})
public class SairController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INDEX = "/pointdopao";

    public SairController() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // Invalida sessão e redireciona para login
        HttpSession session = request.getSession();
        session.setAttribute("autenticado", false);
        session.invalidate();
        //System.out.println("SAIRCONTROLLER: Invalidando Sessão!!");

        String forward = INDEX;
        response.sendRedirect(forward);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bcovies
 */
@WebServlet(name = "LimparController", urlPatterns = {"/limpar"})
public class LimparController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INDEX = "/pointdopao";
    ArrayList<Produto> carrinhoLista = new ArrayList();

    public LimparController() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // Invalida sessão e redireciona para login
        HttpSession session = request.getSession();
        System.out.println("Teste");

        System.out.println(session.getAttribute("carrinhoLista"));
        session.removeAttribute("carrinhoLista");
       
        
        System.out.println("SAIRCONTROLLER: Invalidando Sessão!!");
        String forward = INDEX;
        response.sendRedirect(forward);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    }
    
    
    
}

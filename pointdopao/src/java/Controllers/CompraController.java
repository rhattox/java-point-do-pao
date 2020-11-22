/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
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
@WebServlet(name = "CompraController", urlPatterns = {"/compra"})
public class CompraController extends HttpServlet {

    private static String ENTRAR = "/entrar.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            HttpSession sessionCarrinho = request.getSession();

            System.out.println("1:" + sessionCarrinho.getAttribute("valorTotalCarrinho"));

            
           
             String valorTotalCarrinho = (String) sessionCarrinho.getAttribute("valorTotalCarrinho");

            System.out.println("2:" + valorTotalCarrinho);
            
            Double valorTotalCarrinho2 = Double.parseDouble(valorTotalCarrinho) ;
            
            System.out.println("3:" + valorTotalCarrinho2);
            
            String forward = ENTRAR;
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);

        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

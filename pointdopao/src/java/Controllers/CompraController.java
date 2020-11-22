/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.CarrinhoDao;
import Models.Produto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    CarrinhoDao carrinhoDao = new CarrinhoDao();

    private static String ENTRAR = "/entrar.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            HttpSession sessionCarrinho = request.getSession();
            HttpSession session = request.getSession();
            String SessionValorCarrinho = (String) sessionCarrinho.getAttribute("SessionValorCarrinho");
            Double SessionValorCarrinho2 = Double.parseDouble(SessionValorCarrinho.replace(',', '.'));
            int SessionQntItemCarrinho = (int) sessionCarrinho.getAttribute("SessionProdutoQnt");
            //carrinhoDao.insertProduto(int id, int quantidade);

            System.out.println("Qnt: " + SessionQntItemCarrinho + "   Valor total: " + SessionValorCarrinho2);

            ArrayList<Produto> SessionArrayProduto = (ArrayList<Produto>) sessionCarrinho.getAttribute("SessionCarrinhoProduto");

            System.out.println("Array POST: " + SessionArrayProduto.isEmpty());

            SessionArrayProduto.forEach(produto -> {
                System.out.println("produto ID: " + produto.getId());
                System.out.println("produto Quantidade: " + produto.getQuantidade());
                int idProduto = produto.getId();
                int qntProduto = produto.getQuantidade();

                try {
                    carrinhoDao.insertProduto(idProduto, qntProduto);
                } catch (SQLException ex) {
                    Logger.getLogger(CompraController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

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

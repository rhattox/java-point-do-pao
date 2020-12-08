/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.CarrinhoDao;
import Models.Produto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bcovies
 */
@WebServlet(name = "CompraController", urlPatterns = {"/compra"})
public class CompraController extends HttpServlet {

    CarrinhoDao carrinhoDao = new CarrinhoDao();

    private static String ENTRAR = "/acesso";

    private static String ERRO = "/entrar.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //USUARIO
            HttpSession session = request.getSession();
            //USUARIO ID
            int SessionIdUsuario = (int) session.getAttribute("SessionIdUsuario");

            //CARRINHO
            HttpSession sessionCarrinho = request.getSession();
            //CARRINHO VALOR TOTAL
            String SessionValorCarrinho = (String) sessionCarrinho.getAttribute("SessionValorCarrinho");
            Double SessionValorCarrinho2 = Double.parseDouble(SessionValorCarrinho.replace(',', '.'));
            ArrayList<Produto> SessionListaProduto = (ArrayList<Produto>) sessionCarrinho.getAttribute("SessionCarrinhoProduto");

            //VERIFICA SE TÁ LOGADO
            if (SessionIdUsuario == 0) {
                System.out.println("é nulo");
                String forward = ERRO;
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
            } else {
                //agora monta o carrinho pro banco de dados
                try {
                    int idTabelaCompra = carrinhoDao.insertProduto(SessionIdUsuario, SessionValorCarrinho2);
                    SessionListaProduto.forEach(produto -> {
                        try {
                            carrinhoDao.insertProdutoDetalhe(idTabelaCompra, produto.getId(), produto.getQuantidade());
                            sessionCarrinho.setAttribute("efetuouCompraRecente", true);
                        } catch (SQLException e) {
                            e.getMessage();
                        }
                    });

                } catch (SQLException e) {
                    e.getMessage();
                }

                String forward = ENTRAR;
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

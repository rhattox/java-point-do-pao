package Controllers;

import Dao.ProdutoDao;
import Models.Carrinho;
import Models.Produto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CarrinhoController", urlPatterns = {"/carrinho"})
public class CarrinhoController extends HttpServlet {

    private static String CARRINHO = "/carrinho.jsp";
    ProdutoDao produtoDao = new ProdutoDao();
    Produto produto = new Produto();
    ArrayList<Produto> carrinhoLista = new ArrayList();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String forward = "";
        HttpSession session = request.getSession();

        String produtoId = request.getParameter("produto");
        String qtdItem = request.getParameter("qtd");

        produto = produtoDao.getProductById(produtoId);
        request.setAttribute("produto", produto);

        //carrinhoLista.add(produto);
        request.setAttribute("carrinhoLista", carrinhoLista);

        //carrinhoLista.clear();
        session.setAttribute("carrinhoLista", carrinhoLista.add(produto));

        forward = CARRINHO;

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

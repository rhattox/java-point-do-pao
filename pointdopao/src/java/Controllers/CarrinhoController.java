package Controllers;

import Dao.ProdutoDao;
import Models.Produto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CarrinhoController", urlPatterns = {"/carrinho"})
public class CarrinhoController extends HttpServlet {

    private static String CARRINHO = "/carrinho.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String forward = "";
        String produtoId = request.getParameter("produto");
        String qtdItem = request.getParameter("qtd");
        System.out.println("ID primeiro:" + produtoId);
        ProdutoDao produtoDao = new ProdutoDao();
        Produto produtoRetornado = new Produto();
        produtoRetornado = produtoDao.getProductById(produtoId);
        System.out.println("ID segundo:" + produtoRetornado.getId());
        request.setAttribute("produto", produtoRetornado);
        forward = CARRINHO;

        float valorFinal = 10;

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

    private float calculaPreco(float preco) {

        float valorFinal = 0;

        return valorFinal;

    }

}

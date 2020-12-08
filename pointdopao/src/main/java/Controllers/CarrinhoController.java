package Controllers;

import Dao.ProdutoDao;
import Dao.UsuarioDao;
import Models.Produto;
import Models.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Enumeration;

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
        HttpSession sessionCarrinho = request.getSession();
        if (((boolean) sessionCarrinho.getAttribute("sessionNew")) || ((boolean) sessionCarrinho.getAttribute("efetuouCompraRecente"))) {
            carrinhoLista.clear();
            sessionCarrinho.setAttribute("sessionNew", false);
            sessionCarrinho.setAttribute("efetuouCompraRecente", false);
        }
        UsuarioDao usuarioDao = new UsuarioDao();

        Enumeration<String> params = request.getParameterNames();

        if (params.hasMoreElements()) {
            String removerIndex = request.getParameter("remover");

            if (removerIndex != null) {
                int indexProdRemovido = Integer.parseInt(removerIndex);
                carrinhoLista.remove(indexProdRemovido);
                request.setAttribute("carrinhoLista", carrinhoLista);
            } else {
                String produtoId = request.getParameter("produto");
                int qtdItem = Integer.parseInt(request.getParameter("qtd"));

                produto = produtoDao.getProductById(Integer.parseInt(produtoId));
                produto.setQuantidade(qtdItem);
                carrinhoLista.add(produto);

                request.setAttribute("carrinhoLista", carrinhoLista);
                sessionCarrinho.setAttribute("SessionProdutoId", produto.getId());
                sessionCarrinho.setAttribute("SessionProdutoQnt", produto.getQuantidade());
            }
        }

        sessionCarrinho.setAttribute("SessionCarrinhoProduto", carrinhoLista);

        String valorTotal = calcularTotal(carrinhoLista);

        request.setAttribute("carrinhoLista", carrinhoLista);
        request.setAttribute("total", valorTotal);

        sessionCarrinho.setAttribute("SessionValorCarrinho", valorTotal);

        Usuario usuarioLogado = usuarioDao.getEndereco((Integer) sessionCarrinho.getAttribute("SessionIdUsuario"));
        if (usuarioLogado.getLogradouro() != null) {
            request.setAttribute("usuarioLogado", usuarioLogado);
        }
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

    private String calcularTotal(ArrayList<Produto> carrinhoLista) {
        if (carrinhoLista.size() == 0) {
            return "0,00";
        }

        NumberFormat formatter = new DecimalFormat("#.00");
        double total = 0;
        for (Produto item : carrinhoLista) {
            total += Double.parseDouble(item.getPreco().toString()) * (double) item.getQuantidade();
        }
        return formatter.format(total);
    }
}

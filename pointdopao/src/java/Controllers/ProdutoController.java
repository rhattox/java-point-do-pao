package Controllers;

import Dao.ProdutoDao;
import Dao.UsuarioDao;
import Models.Produto;
import Models.Usuario;
import Utils.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "ProdutoController", urlPatterns = {"/produto"})
public class ProdutoController extends HttpServlet {
    private static int ADM_ID = 1;
    private static String ADM_EMAIL = "ADM";
    private static String HOME = "/pointdopao";
    private static String GESTAO_ADM = "/gestao-produtos.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produto produto = new Produto();
        ProdutoDao produtoDao = new ProdutoDao();
        UsuarioDao usuarioDao = new UsuarioDao();
        String removerIndex = null;
        HttpSession session = request.getSession();

        boolean isAdm = (boolean)session.getAttribute("isAdm");

        Enumeration<String> params = request.getParameterNames();
        if (params.hasMoreElements()) {
            removerIndex = request.getParameter("remover");
            if (removerIndex != null) {
                int indexProdRemovido = Integer.parseInt(removerIndex);
                try {
                    produtoDao.removerProduto(indexProdRemovido);
                } catch (Exception e) {
                    System.out.println("Erro ao excluir produto: " + e.getMessage());
                }
            } else {
                String nomeProdutoForm = request.getParameter("nomeProdutoForm").toLowerCase();
                String precoProdutoForm = request.getParameter("precoProdutoForm").replace(',', '.');
                produto.setNome(nomeProdutoForm);
                produto.setQuantidade(1);
                produto.setPreco(new BigDecimal(precoProdutoForm));
            }
        }

        try {
            String forward = "";
            if (isAdm) {
                if (removerIndex == null) { produtoDao.insertProduto(produto);}
                List<Produto> listaProdutos = produtoDao.getAllProducts();
                request.setAttribute("listaProdutos", listaProdutos);
                forward = GESTAO_ADM;
            } else {
                forward = HOME;
            }
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

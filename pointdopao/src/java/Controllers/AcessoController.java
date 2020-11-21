package Controllers;

import Dao.ProdutoDao;
import Models.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AcessoController", urlPatterns = {"/acesso"})
public class AcessoController extends HttpServlet {

    private static String CADASTRAR = "/cadastro.jsp";
    private static String ENTRAR = "/entrar.jsp";
    private static String REDEFINIR_SENHA = "/redefinir-senha.jsp";
    private static String LIMPAR = "/limpar";
    private static String GESTAO_ADM = "/gestao-produtos.jsp";
    private static String CARRINHO = "/carrinho";
    private static String INDEX = "/index.jsp";
    private static String SAIR = "/sair";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String forward = "";
        String action = request.getParameter("pr");
        HttpSession session = request.getSession();
        if (action == null) {

            session.setAttribute("acesso", false);
            action = "";
        } else {
            session.setAttribute("acesso", true);
        }

        switch (action) {
            case "cadastrar":
                System.out.println("Passando para Cadastro!");
                forward = CADASTRAR;
                break;
            case "gestao":
                System.out.println("Passando para Gestão!");
                forward = GESTAO_ADM;
                break;
            case "carrinho":
                System.out.println("Passando para Carrinho!");
                forward = CARRINHO;
                break;
            case "entrar":
                System.out.println("Passando para Entrar!");
                forward = ENTRAR;
                break;
            case "redefinir":
                System.out.println("Passando para Redefinir!");
                forward = REDEFINIR_SENHA;
                break;
            case "sair":
                System.out.println("Passando para Sair!");
                forward = SAIR;
                break;
            case "limpar":
                System.out.println("Limpando Carrinho!");
                forward = LIMPAR;
                break;
            default:
                System.out.println("Passando para Index!");
                ProdutoDao produtoDao = new ProdutoDao();
                List<Produto> listaProdutos = produtoDao.getAllProducts();
                request.setAttribute("listaProdutos", listaProdutos);
                forward = INDEX;
                break;
        }
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

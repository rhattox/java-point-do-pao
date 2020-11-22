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

@WebServlet(name = "EnderecoController", urlPatterns = {"/atualizar-dados"})
public class EnderecoController extends HttpServlet {

    private static String CARRINHO = "/carrinho.jsp";
    UsuarioDao usuarioDao = new UsuarioDao();
    Usuario usuario = new Usuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String forward = "";

        String endereco = request.getParameter("enderecoCheckoutForm").toUpperCase();
        String numero = request.getParameter("numeroCheckoutForm").toUpperCase();
        String complemento = request.getParameter("cpCheckoutForm").toUpperCase();
        String bairro = request.getParameter("bairroCheckoutForm").toUpperCase();
        String estado = request.getParameter("estadoCheckoutForm").toUpperCase();
        String cep = request.getParameter("cepCheckoutForm").toUpperCase();

        String enderecoCompleto = endereco + ", " + numero + ", " + complemento + " - " + bairro + ", " + estado + " - " + cep;


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

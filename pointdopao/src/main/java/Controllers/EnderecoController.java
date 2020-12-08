package Controllers;

import Dao.UsuarioDao;
import Models.Produto;
import Models.Usuario;

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

@WebServlet(name = "EnderecoController", urlPatterns = {"/atualizar-dados"})
public class EnderecoController extends HttpServlet {

    private static String CARRINHO = "/pointdopao/carrinho";
    UsuarioDao usuarioDao = new UsuarioDao();
    Usuario usuario = new Usuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String forward = "";

        String logradouro = request.getParameter("enderecoCheckoutForm").toUpperCase();
        String numero = request.getParameter("numeroCheckoutForm").toUpperCase();
        String complemento = request.getParameter("cpCheckoutForm").toUpperCase();
        String bairro = request.getParameter("bairroCheckoutForm").toUpperCase();
        String estado = request.getParameter("estadoCheckoutForm").toUpperCase();
        String cep = request.getParameter("cepCheckoutForm").toUpperCase();

        try {
            boolean sucesso = usuarioDao.insertEndereco(
                    logradouro,
                    numero,
                    complemento,
                    bairro,
                    estado,
                    cep,
                    (int) session.getAttribute("SessionIdUsuario"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        forward = CARRINHO;
        response.sendRedirect(forward);;
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

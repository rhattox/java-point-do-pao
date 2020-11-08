package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AcessoController", urlPatterns = {"/acesso"})
public class AcessoController extends HttpServlet {

    private static String CADASTRAR = "/cadastro.jsp";
    private static String ENTRAR = "/entrar.jsp";
    private static String REDEFINIR_SENHA = "/redefinir-senha.jsp";
    private static String INDEX = "/index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String forward = "";
        String action = request.getParameter("pr");

        switch (action) {
            case "cadastrar":
                forward = CADASTRAR;
                break;
            case "entrar":
                forward = ENTRAR;
                break;
            case "redefinir":
                forward = REDEFINIR_SENHA;
                break;
            default:
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

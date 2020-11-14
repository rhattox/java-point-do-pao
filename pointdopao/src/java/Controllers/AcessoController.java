package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
    private static String INDEX = "/index.jsp";
    private static String SAIR = "/sair";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String forward = "";
        String action = request.getParameter("pr");
        HttpSession session = request.getSession();
        if (action == null) {
            
            session.setAttribute("autenticado", false);
            action = "";
        } else {
            session.setAttribute("autenticado", true);
        }
        
        switch (action) {
            case "cadastrar":
                System.out.println("Passando para Cadastro!");
                forward = CADASTRAR;
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
            default:
                System.out.println("Passando para Index!");
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

package Controllers;

import Dao.UsuarioDao;
import Models.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EntrarController", urlPatterns = {"/entrar"})
public class EntrarController extends HttpServlet {

    private static String POSTLOGIN = "/index.jsp";
    private static String LOGADO = "/administracao-usuario.jsp";
    private static String ERROR = "/entrar.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario();

        usuario.setEmail(request.getParameter("emailLoginForm"));
        usuario.setSenha(request.getParameter("senhaLoginForm"));
        System.out.println("\nENTRARCONROLLER:\nEmail: " + request.getParameter("emailLoginForm") + "\t Senha: " + request.getParameter("senhaLoginForm"));

        try {

            Boolean login = usuarioDao.searchUser(usuario.getEmail(), usuario.getSenha());
            if (login) {
                HttpSession session = request.getSession();
                String SessionEmail = usuario.getEmail();
                session.setAttribute("SessionEmail", SessionEmail);
                System.out.println("Email de sessão: "+SessionEmail);
                System.out.println("\nENTRARCONROLLER:\nA query retornou verdadeira, você está logado!");
                String forward = POSTLOGIN;
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);

            } else {
                System.out.println("\nENTRARCONROLLER:\nA query retornou falsa, você NÃO está logado!");
                String forward = ERROR;
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

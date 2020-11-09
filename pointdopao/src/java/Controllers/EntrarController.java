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

        String emailLoginForm = request.getParameter("emailLoginForm");
        String senhaLoginForm = request.getParameter("senhaLoginForm");

        usuario.setEmail(emailLoginForm);
        usuario.setSenha(senhaLoginForm);
        System.out.println(request.getParameter("emailLoginForm") + request.getParameter("senhaLoginForm"));

        try {

            Boolean login = usuarioDao.searchUser(usuario.getEmail(), usuario.getSenha());
            if (login) {

                System.out.println("\nENTRARCONROLLER:\nA query retornou verdadeira, você está logado!");
                // HttpSession session = request.getSession();
                //session.setAttribute("EmailSession", usuario.getEmail());
//                String forward = POSTLOGIN;
                String forward = ERROR;

                String nome = usuarioDao.searchUsernameByEmail(emailLoginForm);

                HttpSession session = request.getSession();
                session.setAttribute("nome", nome);
                session.setAttribute("email", emailLoginForm);

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

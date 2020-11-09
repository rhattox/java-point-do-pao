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

@WebServlet(name = "RedefinirSenhaController", urlPatterns = {"/redefinir"})
public class RedefinirSenhaController extends HttpServlet {

    private static String REDEFINIR_SENHA = "/redefinir-senha.jsp";
    private static String POSTLOGIN = "/index.jsp";
    private static String ERROR = "/redefinir-senha.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario();

        usuario.setEmail(request.getParameter("emailResetForm"));
        usuario.setSenha(request.getParameter("novaSenhaResetForm"));
        System.out.println(request.getParameter("emailResetForm") + request.getParameter("novaSenhaResetForm"));

        try {

            Boolean reset = usuarioDao.changeUserPass(usuario.getEmail(), usuario.getSenha());
            if (reset) {
                String forward = POSTLOGIN;
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
            } else {
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

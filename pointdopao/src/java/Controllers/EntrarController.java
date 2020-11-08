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

@WebServlet(name = "EntrarController", urlPatterns = {"/entrar"})
public class EntrarController extends HttpServlet {

    private static String POSTLOGIN = "/index.jsp";
    private static String ERROR = "/entrar.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario();

        usuario.setEmail(request.getParameter("emailLoginForm"));
        usuario.setSenha(request.getParameter("senhaLoginForm"));
        System.out.println(request.getParameter("emailLoginForm") + request.getParameter("senhaLoginForm"));
        
        try {

            Boolean login = usuarioDao.searchUser(usuario.getEmail(), usuario.getSenha());
            if (login) {
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

package Controllers;

import Dao.UsuarioDao;
import Models.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EntrarController", urlPatterns = {"/entrar"})
public class EntrarController extends HttpServlet {

    
    private static String POSTLOGIN = "/index.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario();

        
        usuario.setEmail(request.getParameter("emailForm"));
        usuario.setSenha(request.getParameter("senhaForm"));
        System.out.println( request.getParameter("emailForm") +  request.getParameter("senhaForm") );

        try {
            usuarioDao.insertUser(usuario);
            String forward = POSTLOGIN;
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

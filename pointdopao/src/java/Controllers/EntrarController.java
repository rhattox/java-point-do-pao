package Controllers;

import Dao.ProdutoDao;
import Dao.UsuarioDao;
import Models.Produto;
import Models.Usuario;
import Utils.StringUtils;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EntrarController", urlPatterns = {"/entrar"})
public class EntrarController extends HttpServlet {
    
    private static String ADM_LOGIN = "ADM";
    private static String ADM_SENHA = "Pointdopao";

    private static String POSTLOGIN = "/acesso";
    private static String ERROR = "/entrar.jsp";
    private static String GESTAO_ADM = "/gestao-produtos.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario();

        String emailLoginForm = request.getParameter("emailLoginForm").toUpperCase();
        String senhaLoginForm = request.getParameter("senhaLoginForm");
        usuario.setEmail(emailLoginForm);
        usuario.setSenha(senhaLoginForm);
        //System.out.println("\nENTRARCONROLLER:\nEmail: " + request.getParameter("emailLoginForm") + "\t Senha: " + request.getParameter("senhaLoginForm"));

        try {
            Boolean login = usuarioDao.authByEmailSenha(usuario.getEmail(), usuario.getSenha());
            request.getSession().invalidate();
            HttpSession session = request.getSession();
            session.setAttribute("sessionNew", true);
            if (login) {
                Usuario usuarioSession = usuarioDao.searchUsernameByEmail(usuario.getEmail(), usuario.getSenha());
                String forward = "";
                if (ehAdm(emailLoginForm, senhaLoginForm)) {
                    setSessionAttr(session, usuarioSession, true);

                    ProdutoDao produtoDao = new ProdutoDao();
                    List<Produto> listaProdutos = produtoDao.getAllProducts();
                    request.setAttribute("listaProdutos", listaProdutos);
                    forward = GESTAO_ADM;
                } else {
                    setSessionAttr(session, usuarioSession, false);

                    forward = POSTLOGIN;
                }   
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
                
            } else {
                //System.out.println("\nENTRARCONROLLER:\nA query retornou falsa, você NÃO está logado!");
                session.setAttribute("autenticado", false);
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
    
    private boolean ehAdm(String emailLoginForm, String senhaLoginForm) {
        return emailLoginForm.equals(ADM_LOGIN.toUpperCase()) && senhaLoginForm.equals(ADM_SENHA);
    }

    private void setSessionAttr(HttpSession session, Usuario usuarioSession, boolean isAdm) {
        session.setAttribute("SessionIdUsuario", usuarioSession.getId());
        session.setAttribute("SessionNome", StringUtils.capitalize(usuarioSession.getNome()));
        session.setAttribute("SessionEmail", usuarioSession.getEmail());
        session.setAttribute("isAdm", isAdm);
        session.setAttribute("autenticado", true);
    }
}

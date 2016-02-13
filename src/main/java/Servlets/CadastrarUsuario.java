package Servlets;

import Entidades.Usuario;
import Fabricas.DaoFactory;
import Gerenciadores.GerenciadorDeUsuario;
import Interfaces.UsuarioDaoIF;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class CadastrarUsuario extends HttpServlet {

    private GerenciadorDeUsuario usuarioGer = new GerenciadorDeUsuario();

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String nomeCompleto = request.getParameter("nome");
        String apelido = request.getParameter("apelido");
        String senha = request.getParameter("senha");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String foto = request.getParameter("foto");
        String dataNascimento = request.getParameter("dataNascimento");
        String tipo = request.getParameter("tipo");
//        String sexo = request.getParameter("sexo");

        GerenciadorDeUsuario usuario = new GerenciadorDeUsuario();

        try {
            usuarioGer.adicionarUsuario(email, nomeCompleto, apelido, senha, cidade, estado, foto, dataNascimento, tipo);
            request.setAttribute("usuario", usuarioGer);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("index.jsp");

            dispatcher.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

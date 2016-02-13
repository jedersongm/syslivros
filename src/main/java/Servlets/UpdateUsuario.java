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
import javax.servlet.http.HttpSession;

public class UpdateUsuario extends HttpServlet {

    private GerenciadorDeUsuario usuarioGer = new GerenciadorDeUsuario();

    public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        Usuario usuario = new Usuario();
        
        usuario.setEmail(request.getParameter("email"));
        usuario.setNome(request.getParameter("nome"));
        usuario.setApelido(request.getParameter("apelido"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setCidade(request.getParameter("cidade"));
        usuario.setEstado(request.getParameter("estado"));
        usuario.setDataNascimento(request.getParameter("dataNascimento"));
        usuario.setFoto(request.getParameter("foto"));
        usuario.setTipo(request.getParameter("tipo"));
//        usuario.setSexo(request.getParameter("sexo"));
        try {
            usuarioGer.atualizaUsuario(usuario);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ListarUsuarios");

        dispatcher.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(UpdateUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

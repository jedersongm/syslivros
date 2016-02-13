package Teste;



import Gerenciadores.GerenciadorDeGrupo;
import Gerenciadores.GerenciadorDeUsuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;

public class SisMovies {

    public static void main(String[] args) throws SQLException, ServletException, IOException {
   
        GerenciadorDeUsuario u = new GerenciadorDeUsuario();
        System.out.println(u.pesquisarUsuario("Gerson"));
        
        
    }
}

package DAO;

import Conexao.Conexao;
import Conexao.ConnectionFactory;
import Entidades.Topico;
import Interfaces.TopicoDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicoDao implements TopicoDaoIF {
    ConnectionFactory factory = new ConnectionFactory();
    Conexao conexao = new Conexao();
    Connection con;
    PreparedStatement pstm;
    
    public TopicoDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }
    
    public void inserir(Topico t) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "INSERT INTO Topico(titulo, texto, data, usuario, id_grupo) VALUES (?,?,?,?)";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, t.getTitulo());
            pstm.setString(2, t.getTexto());
            pstm.setTimestamp(3, t.getData());
            pstm.setString(4, t.getUsuario().getEmail());
            pstm.setInt(5, t.getGrupo().getId());
            pstm.executeUpdate();

            pstm.executeUpdate();

        } finally {
            conexao.liberar();
        }
    }

    public void remover(Topico t) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "delete from topico where titulo=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, t.getTitulo());

            pstm.executeUpdate();
        } finally {
            conexao.liberar();
        }
    }

    public void atualizar(Topico t) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "update Topico set titulo=?, conteudo=? where id=?";
            
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, t.getTitulo());
            pstm.setString(2, t.getTexto());
            pstm.setTimestamp(3, t.getData());
            pstm.setString(4, t.getUsuario().getEmail());
            pstm.setInt(5, t.getGrupo().getId());

            pstm.executeUpdate();
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
    }

    public Topico pesquisar(String titulo) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "select * from topico where titulo ilike '%"+ titulo +"%'";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
            
            Topico topico = new Topico();
            
            while(result.next()){
                topico.setId(result.getInt("id"));
                topico.setTitulo(result.getString("titulo"));
                topico.setTexto(result.getString("texto"));
            }
            return topico;
            
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
}
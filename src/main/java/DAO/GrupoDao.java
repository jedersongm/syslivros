package DAO;

import Conexao.Conexao;
import Conexao.ConnectionFactory;
import Entidades.Grupo;
import Entidades.Usuario;
import Interfaces.GrupoDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrupoDao implements GrupoDaoIF{
    ConnectionFactory factory = new ConnectionFactory();
    Conexao conexao = new Conexao();
    Connection con;
    PreparedStatement pstm;
    
    public GrupoDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }
    
    public void inserir(Grupo grupo, Usuario usuario) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "insert into Grupo(emailUsuario, nome, descricao) values (?,?,?)";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, usuario.getEmail());
            pstm.setString(2, grupo.getNome());
            pstm.setString(3, grupo.getDescricao());

            pstm.executeUpdate();

        } finally {
            conexao.liberar();
        }
    }

    public void remover(Grupo g) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "delete from grupo where nome=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, g.getNome());

            pstm.executeUpdate();
        } finally {
            conexao.liberar();
        }
    }

    public void atualizar(Grupo g) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "update Grupo set nome=?, descricao=? where id=?";
            
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, g.getNome());
            pstm.setString(2, g.getDescricao());
            pstm.setInt(3, g.getId());

            pstm.executeUpdate();
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
    }

    public Grupo pesquisar(String nome) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "select * from grupo where nome ilike '%"+ nome +"%'";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
            
            Grupo grupo = new Grupo();
            
            while(result.next()){
                grupo.setId(result.getInt("id"));
                grupo.setNome(result.getString("nome"));
                grupo.setDescricao(result.getString("descricao"));
            }
            return grupo;
            
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
    
    public List<Grupo> pesquisarGrupos(String nome) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "select id, nome, descricao from Grupo where nome ilike '%"+ nome +"%'";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
            
            List<Grupo> grupos = new ArrayList<Grupo>();
            
            while(result.next()){
                Grupo grupo = new Grupo();
                grupo.setId(result.getInt("id"));
                grupo.setNome(result.getString("nome"));
                grupo.setDescricao(result.getString("descricao"));
                
                grupos.add(grupo);
            }
            return grupos.isEmpty() ? null : grupos;
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
}
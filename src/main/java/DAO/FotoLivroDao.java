package DAo;

import Conexao.Conexao;
import Conexao.ConnectionFactory;
import Entidades.Foto;
import Entidades.Usuario;
import Interfaces.FotoLivroDaoIF;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class FotoLivroDao implements FotoLivroDaoIF {
    ConnectionFactory factory = new ConnectionFactory();
    Conexao conexao = new Conexao();
    Connection con;
    PreparedStatement pstm;
    
    public FotoLivroDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }
 
    @Override
    public void publicarFoto(Foto foto) throws SQLException {
        try{
           conexao.abrir();
            String sql="INSERT INTO Foto(url,data,usuario) VALUES (?,?,?)";
            PreparedStatement stat=con.prepareStatement(sql);
            stat.setString(1, foto.getUrl());
            stat.setTimestamp(2, foto.getData());
            stat.setInt(3, foto.getUsuario().getId());
            stat.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }finally {
            conexao.liberar();
        }
    }

    @Override
    public List<Foto> listarFotos(Integer id_usuario) throws SQLException {
        try{
            conexao.abrir();
            String sql="SELECT * FROM Foto WHERE usuario=? ORDER BY data DESC";
            PreparedStatement stat=con.prepareStatement(sql);
            stat.setInt(1, id_usuario);
            ResultSet rs=stat.executeQuery();
            List<Foto> fotos=new LinkedList<>();
            while(rs.next()){
                Foto foto=new Foto();
                foto.setData(rs.getTimestamp("data"));
                foto.setUrl(rs.getString("url"));
                foto.setUsuario(null);
                fotos.add(foto);
            }
            return fotos.isEmpty()?null:fotos;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.FotoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            conexao.liberar();
        }
        return null;
    }
}

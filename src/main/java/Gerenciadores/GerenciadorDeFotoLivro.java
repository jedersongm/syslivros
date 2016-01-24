package Gerenciadores;

import Entidades.Foto;
import Entidades.Usuario;
import Fabricas.DaoFactory;
import Fabricas.DaoFactoryIF;
import Interfaces.FotoDaoIF;
import Interfaces.FotoLivroDaoIF;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.ImageIcon;

public class GerenciadorDeFotoLivro {
    
    public void publicarFoto(String url, Timestamp data, Usuario usuario) throws SQLException {
        Foto foto = new Foto();
        foto.setData(data);
        foto.setUrl(url);
        foto.setUsuario(usuario);
        DaoFactoryIF daoFactory =DaoFactory.creatFactory();
        FotoLivroDaoIF fotoLivroDao = daoFactory.criaFotoLivroDao();
        fotoLivroDao.publicarFoto(foto);
    }
    
    public List<Foto> listarFotos(Integer id_usuario) throws SQLException{
        DaoFactoryIF daoFactory =DaoFactory.creatFactory();
        FotoLivroDaoIF fotoLivroDao = daoFactory.criaFotoLivroDao();
        return fotoLivroDao.listarFotos(id_usuario);
    }
}
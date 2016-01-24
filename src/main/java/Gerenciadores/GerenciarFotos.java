package Gerenciadores;

import Entidades.Foto;
import Entidades.Usuario;
import Fabricas.DaoFactory;
import Fabricas.DaoFactoryIF;
import Interfaces.FotoDaoIF;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Emanuel Batista da Silva Filho <emanuelbatista2011@gmail.com>
 * @date 16/02/2015 ás 21:36:10
 */
public class GerenciarFotos {

    public void publicarFoto(String url, Usuario usuario) throws SQLException {
        Foto foto = new Foto();
        foto.setUrl(url);
        foto.setUsuario(usuario);
        DaoFactoryIF daoFactory =DaoFactory.creatFactory();
        FotoDaoIF fotoDao = daoFactory.criaFotoDao();
        fotoDao.publicarFoto(foto);
    }
    
    public List<Foto> listarFotos(Integer id_usuario) throws SQLException{
        DaoFactoryIF daoFactory =DaoFactory.creatFactory();
        FotoDaoIF fotoDao = daoFactory.criaFotoDao();
        return fotoDao.listarFotos(id_usuario);
    }
}

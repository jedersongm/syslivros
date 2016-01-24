package Interfaces;

import Entidades.Foto;
import Entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
//import org.apache.commons.fileupload.FileItem;

public interface FotoLivroDaoIF {
    
    public void publicarFoto(Foto foto) throws SQLException;
    
    public List<Foto> listarFotos(Integer id_usuario) throws SQLException;
}

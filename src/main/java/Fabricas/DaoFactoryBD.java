package Fabricas;

import DAO.AmizadeDao;
import DAO.AutoresDao;
import DAO.ComentarioDao;
import DAO.FotoDAO;
import DAO.LivroDao;
import DAO.GrupoDao;
import DAO.TopicoDao;
import DAO.UsuarioDao;
import DAo.FotoLivroDao;
import Interfaces.AmizadeDaoIF;
import Interfaces.AutoresDaoIF;
import Interfaces.ComentarioDaoIF;
import Interfaces.FotoDaoIF;
import Interfaces.LivroDaoIF;
import Interfaces.FotoLivroDaoIF;
import Interfaces.GrupoDaoIF;
import Interfaces.TopicoDaoIF;
import Interfaces.UsuarioDaoIF;

public class DaoFactoryBD implements DaoFactoryIF{
    
    private DaoFactoryBD instance;
    
    public AmizadeDaoIF criaAmizadeDao() {
        return new AmizadeDao();
    }

    public AutoresDaoIF criaAutoresDao() {
        return new AutoresDao();
    }
    @Override
    public ComentarioDaoIF criaComentarioDao() {
        return new ComentarioDao();
    }

    @Override
    public FotoDaoIF criaFotoDao() {
        return new FotoDAO();
    }
    
    public FotoLivroDaoIF criaFotoLivroDao() {
        return new FotoLivroDao();
    }
    
    public LivroDaoIF criaLivroDao() {
        return new LivroDao();
    }
    
    public GrupoDaoIF criaGrupoDao() {
        return new GrupoDao();
    }

    public TopicoDaoIF criaTopicoDao() {
        return new TopicoDao();
    }

    public UsuarioDaoIF criaUsuarioDao() {
        return new UsuarioDao();
    }
    
    

}

package Fabricas;

import Interfaces.AmizadeDaoIF;
import Interfaces.AutoresDaoIF;
import Interfaces.ComentarioDaoIF;
import Interfaces.FotoDaoIF;
import Interfaces.LivroDaoIF;
import Interfaces.FotoLivroDaoIF;
import Interfaces.GrupoDaoIF;
import Interfaces.TopicoDaoIF;
import Interfaces.UsuarioDaoIF;

public interface DaoFactoryIF {
    
    public AmizadeDaoIF criaAmizadeDao();
    
    public AutoresDaoIF criaAutoresDao();
    
    public ComentarioDaoIF criaComentarioDao();
    
    public FotoDaoIF criaFotoDao();
    
    public FotoLivroDaoIF criaFotoLivroDao();
    
    public GrupoDaoIF criaGrupoDao();
    
    public LivroDaoIF criaLivroDao();
    
    public TopicoDaoIF criaTopicoDao();
    
    public UsuarioDaoIF criaUsuarioDao();
}

package Gerenciadores;

import Entidades.Amizade;
import Entidades.Usuario;
import Fabricas.DaoFactory;
import Fabricas.DaoFactoryIF;
import Interfaces.AmizadeDaoIF;
import java.sql.SQLException;
import java.util.ArrayList;

public class GerenciadorDeAmizade {
    
    public void adicionarAmizade(Usuario usuario, Usuario amigo) throws SQLException{
        Amizade novaAmizade = new Amizade();
        novaAmizade.setEmailUsuario(usuario.getEmail());
        novaAmizade.setEmailAmigo(amigo.getEmail());
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AmizadeDaoIF amizadeDao = fabrica.criaAmizadeDao();
        amizadeDao.inserir(novaAmizade); 
    }
    
    public void removerAmizade(Amizade a) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AmizadeDaoIF amizadeDao = fabrica.criaAmizadeDao();
        amizadeDao.remover(a);
    }
    
    public void atualizaAmizade(Amizade a) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AmizadeDaoIF amizadeDao = fabrica.criaAmizadeDao();
        amizadeDao.atualizar(a);
    }
    
    public Amizade pesquisarAmizade(String emailUsuario) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AmizadeDaoIF amizadeDao = fabrica.criaAmizadeDao();
        return amizadeDao.pesquisar(emailUsuario);
    }
    
    public ArrayList<Amizade> listarAmizade(String emailUsuario) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AmizadeDaoIF amizadeDao = fabrica.criaAmizadeDao();
        return amizadeDao.listar(emailUsuario);
    }
    
}

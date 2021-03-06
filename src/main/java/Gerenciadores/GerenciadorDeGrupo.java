package Gerenciadores;

import Entidades.Grupo;
import Entidades.Usuario;
import Fabricas.DaoFactory;
import Fabricas.DaoFactoryIF;
import Interfaces.GrupoDaoIF;
import java.sql.SQLException;
import java.util.List;

public class GerenciadorDeGrupo {
    
    public void adicionarGrupo(Usuario usuario, String nome, String descricao) throws SQLException{
        Grupo novoGrupo = new Grupo();
        novoGrupo.setEmailUsuario(usuario.getEmail());
        novoGrupo.setNome(nome);
        novoGrupo.setDescricao(descricao);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        GrupoDaoIF gruDao = fabrica.criaGrupoDao();
        gruDao.inserir(novoGrupo, usuario);
    }
    
    public void removerGrupo(Grupo grupo) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        GrupoDaoIF gruDao = fabrica.criaGrupoDao();
        gruDao.remover(grupo);
    }
    
    public void atualizaGrupo(Grupo grupo) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        GrupoDaoIF gruDao = fabrica.criaGrupoDao();
        gruDao.atualizar(grupo);
    }
    
    public Grupo pesquisarGrupo(String nome) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        GrupoDaoIF gruDao = fabrica.criaGrupoDao();
        return gruDao.pesquisar(nome);
    }
    
    public List<Grupo> pesquisarGrupos(String nome) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        GrupoDaoIF gruDao = fabrica.criaGrupoDao();
        return gruDao.pesquisarGrupos(nome);
    }
}

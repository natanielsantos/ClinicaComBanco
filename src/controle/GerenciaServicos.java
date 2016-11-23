/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.ServicoDAO;
import DAO.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Servico;

/**
 *
 * @author nataniel
 */
public class GerenciaServicos {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClinicaComBancoPU");
    ServicoDAO servicoDAO = new ServicoDAO(emf);
    
    public void cadastraServico(Servico c){
        
        servicoDAO.cadastrar(c);
        
    }
    
    public void alterar(Servico s) throws Exception{
        
        servicoDAO.alterar(s);
        
    }
    
    public void excluir(int ids) throws NonexistentEntityException{
        
        servicoDAO.excluir(ids);
        
    }
    public Servico buscaServicos(int id){
        
        return servicoDAO.localizaServico(id);
        
    }
    
    public List<Servico> listaServicos(){
        
        return servicoDAO.listaServicos();
        
    }
}

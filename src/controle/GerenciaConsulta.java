/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.ClienteDAO;
import DAO.ConsultaDAO;
import DAO.exceptions.NonexistentEntityException;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Cliente;
import modelo.Consulta;

/**
 *
 * @author nataniel
 */
public class GerenciaConsulta {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClinicaComBancoPU");
    private Config cfg;
    private Consulta con;
    private ConsultaDAO consultaDao;
    private Date dataNasc;
    
    public GerenciaConsulta() {
        
        con = new Consulta();
        consultaDao = new ConsultaDAO(emf);
        cfg = new Config();
        
    }
    
    public void cadastrar(Consulta c){
        
        consultaDao.cadastrar(c);
        
    }
    
    public void alterar(Consulta c) throws Exception{
        consultaDao.alterar(c);
    }
    
    public void excluir(int id) throws NonexistentEntityException{
        consultaDao.excluir(id);
    }
    
    public Consulta localizaConsulta(int id){
        
       return consultaDao.localizaConsulta(id);
       
    }
    
    
}

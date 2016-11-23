/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.ClienteDAO;
import DAO.exceptions.NonexistentEntityException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Cliente;

/**
 *
 * @author nataniel
 */
public class GerenciaCliente {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClinicaComBancoPU");
    private Config cfg;
    private Cliente cli;
    private ClienteDAO cliDao;
    private Date dataNasc;
    
    public GerenciaCliente() {
        cli = new Cliente();
        cliDao = new ClienteDAO(emf);
        cfg = new Config();
    }
    
    public void cadastrar(String nomeCli, String rgCli, String cpfCli, String sexoCli, 
                           String dtNascCli, String lgrCli, String numCli, String cidCli, 
                           String estCli, String tel1Cli, String tel2Cli) throws Exception{
        
        dataNasc = cfg.formataData(dtNascCli);
        
        cli.setNomeCli(nomeCli);
        cli.setRgCli(rgCli);
        cli.setCpfCli(cpfCli);
        cli.setSexoCli(sexoCli);
        cli.setDtNascCli(dataNasc);
        cli.setLgrCli(lgrCli);
        cli.setNumCli(numCli);
        cli.setCidCli(cidCli);
        cli.setEstCli(estCli);
        cli.setTel1Cli(tel1Cli);
        cli.setTel2Cli(tel2Cli);
        
        cliDao.cadastrar(cli);
    }
    
    public int qtdCliente(){
        return cliDao.contaClientes();
    }
    
    public void excluir(int idCLi) throws NonexistentEntityException{
        
        cliDao.excluir(idCLi);
        
    }
    
    public void alterar(Cliente cliente) throws Exception{
        
        cliDao.alterar(cliente);
    }
    
    public List<Cliente> listaCliente(){
        return cliDao.listaClientes();
    }
    
    public Cliente buscaCliente(int id){
        Cliente cli;
        
        cli = cliDao.localizaCliente(id);
        
        return cli;
    }
    
    public List<Cliente> filtraNome(String filtro){
        
        return cliDao.filtraPorNome(filtro);
        
    }
}

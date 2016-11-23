/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.AnimalDAO;
import DAO.ClienteDAO;
import DAO.exceptions.NonexistentEntityException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import modelo.Animal;
import modelo.Cliente;

/**
 *
 * @author nataniel
 */
public class GerenciaAnimal {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClinicaComBancoPU");
    private Config cfg;
    private Animal animal;
    private Cliente cli;
    private ClienteDAO cliDao;
    private AnimalDAO aniDao;
    private Date data;
    
    public GerenciaAnimal(){
        aniDao = new AnimalDAO(emf);
        cliDao = new ClienteDAO(emf);
        animal = new Animal();
        cfg = new Config();
    }
    
    public void cadastrar(Cliente id_cliente, String nome_animal, String data_nascimento, Double peso, String cor_pelagem,
            String especie, String raca, String sexo, String obs){
       
        
        try {
            data = cfg.formataData(data_nascimento);
        } catch (Exception ex) {
            Logger.getLogger(GerenciaAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        animal.setIdCliente(id_cliente);
        animal.setNomeAnimal(nome_animal);
        animal.setDataNascimento(data);
        animal.setPeso(peso);
        animal.setCorPelagem(cor_pelagem);
        animal.setEspecie(especie);
        animal.setRaca(raca);
        animal.setSexo(sexo);
        animal.setObs(obs);
        
        try {
            aniDao.cadastrar(animal);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Erro ao enviar para o banco o animal!");
        }
        
    }
    
    public void alterar(Animal novoAnimal){
        
        try {
            aniDao.alterar(animal);
        } catch (Exception ex) {
            Logger.getLogger(GerenciaAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(Animal excluiAnimal){
        
        try {
            aniDao.excluir(excluiAnimal.getIdAnimal());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(GerenciaAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Animal buscaAnimal(int id){
        
       animal = aniDao.localizaAnimal(id);
       
       return animal;
    }
    
    public List<Animal> listaAnimais(){
        return aniDao.listarAnimal();
    }
}

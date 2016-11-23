/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Animal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Cliente;

/**
 *
 * @author nataniel
 */
public class ClienteDAO implements Serializable {

    public ClienteDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void cadastrar(Cliente cliente) {
        if (cliente.getAnimalCollection() == null) {
            cliente.setAnimalCollection(new ArrayList<Animal>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Animal> attachedAnimalCollection = new ArrayList<Animal>();
            for (Animal animalCollectionAnimalToAttach : cliente.getAnimalCollection()) {
                animalCollectionAnimalToAttach = em.getReference(animalCollectionAnimalToAttach.getClass(), animalCollectionAnimalToAttach.getIdAnimal());
                attachedAnimalCollection.add(animalCollectionAnimalToAttach);
            }
            cliente.setAnimalCollection(attachedAnimalCollection);
            em.persist(cliente);
            for (Animal animalCollectionAnimal : cliente.getAnimalCollection()) {
                Cliente oldIdClienteOfAnimalCollectionAnimal = animalCollectionAnimal.getIdCliente();
                animalCollectionAnimal.setIdCliente(cliente);
                animalCollectionAnimal = em.merge(animalCollectionAnimal);
                if (oldIdClienteOfAnimalCollectionAnimal != null) {
                    oldIdClienteOfAnimalCollectionAnimal.getAnimalCollection().remove(animalCollectionAnimal);
                    oldIdClienteOfAnimalCollectionAnimal = em.merge(oldIdClienteOfAnimalCollectionAnimal);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void alterar(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getIdCli());
            Collection<Animal> animalCollectionOld = persistentCliente.getAnimalCollection();
            Collection<Animal> animalCollectionNew = cliente.getAnimalCollection();
            Collection<Animal> attachedAnimalCollectionNew = new ArrayList<Animal>();
            for (Animal animalCollectionNewAnimalToAttach : animalCollectionNew) {
                animalCollectionNewAnimalToAttach = em.getReference(animalCollectionNewAnimalToAttach.getClass(), animalCollectionNewAnimalToAttach.getIdAnimal());
                attachedAnimalCollectionNew.add(animalCollectionNewAnimalToAttach);
            }
            animalCollectionNew = attachedAnimalCollectionNew;
            cliente.setAnimalCollection(animalCollectionNew);
            cliente = em.merge(cliente);
            for (Animal animalCollectionOldAnimal : animalCollectionOld) {
                if (!animalCollectionNew.contains(animalCollectionOldAnimal)) {
                    animalCollectionOldAnimal.setIdCliente(null);
                    animalCollectionOldAnimal = em.merge(animalCollectionOldAnimal);
                }
            }
            for (Animal animalCollectionNewAnimal : animalCollectionNew) {
                if (!animalCollectionOld.contains(animalCollectionNewAnimal)) {
                    Cliente oldIdClienteOfAnimalCollectionNewAnimal = animalCollectionNewAnimal.getIdCliente();
                    animalCollectionNewAnimal.setIdCliente(cliente);
                    animalCollectionNewAnimal = em.merge(animalCollectionNewAnimal);
                    if (oldIdClienteOfAnimalCollectionNewAnimal != null && !oldIdClienteOfAnimalCollectionNewAnimal.equals(cliente)) {
                        oldIdClienteOfAnimalCollectionNewAnimal.getAnimalCollection().remove(animalCollectionNewAnimal);
                        oldIdClienteOfAnimalCollectionNewAnimal = em.merge(oldIdClienteOfAnimalCollectionNewAnimal);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cliente.getIdCli();
                if (localizaCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void excluir(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getIdCli();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            Collection<Animal> animalCollection = cliente.getAnimalCollection();
            for (Animal animalCollectionAnimal : animalCollection) {
                animalCollectionAnimal.setIdCliente(null);
                animalCollectionAnimal = em.merge(animalCollectionAnimal);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> listaClientes() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cliente localizaCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int contaClientes() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Cliente> filtraPorNome(String filtro){
        EntityManager em = getEntityManager();
        
        return em.createQuery("SELECT c from Cliente c WHERE c.nomeCli LIKE '" + filtro + "%'").getResultList();
    }
    
}

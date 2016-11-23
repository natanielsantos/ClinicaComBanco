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
import modelo.Cliente;
import modelo.Consulta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Animal;

/**
 *
 * @author nataniel
 */
public class AnimalDAO implements Serializable {

    public AnimalDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void cadastrar(Animal animal) {
        if (animal.getConsultaCollection() == null) {
            animal.setConsultaCollection(new ArrayList<Consulta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente idCliente = animal.getIdCliente();
            if (idCliente != null) {
                idCliente = em.getReference(idCliente.getClass(), idCliente.getIdCli());
                animal.setIdCliente(idCliente);
            }
            Collection<Consulta> attachedConsultaCollection = new ArrayList<Consulta>();
            for (Consulta consultaCollectionConsultaToAttach : animal.getConsultaCollection()) {
                consultaCollectionConsultaToAttach = em.getReference(consultaCollectionConsultaToAttach.getClass(), consultaCollectionConsultaToAttach.getIdConsulta());
                attachedConsultaCollection.add(consultaCollectionConsultaToAttach);
            }
            animal.setConsultaCollection(attachedConsultaCollection);
            em.persist(animal);
            if (idCliente != null) {
                idCliente.getAnimalCollection().add(animal);
                idCliente = em.merge(idCliente);
            }
            for (Consulta consultaCollectionConsulta : animal.getConsultaCollection()) {
                Animal oldIdAnimalOfConsultaCollectionConsulta = consultaCollectionConsulta.getIdAnimal();
                consultaCollectionConsulta.setIdAnimal(animal);
                consultaCollectionConsulta = em.merge(consultaCollectionConsulta);
                if (oldIdAnimalOfConsultaCollectionConsulta != null) {
                    oldIdAnimalOfConsultaCollectionConsulta.getConsultaCollection().remove(consultaCollectionConsulta);
                    oldIdAnimalOfConsultaCollectionConsulta = em.merge(oldIdAnimalOfConsultaCollectionConsulta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void alterar(Animal animal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Animal persistentAnimal = em.find(Animal.class, animal.getIdAnimal());
            Cliente idClienteOld = persistentAnimal.getIdCliente();
            Cliente idClienteNew = animal.getIdCliente();
            Collection<Consulta> consultaCollectionOld = persistentAnimal.getConsultaCollection();
            Collection<Consulta> consultaCollectionNew = animal.getConsultaCollection();
            if (idClienteNew != null) {
                idClienteNew = em.getReference(idClienteNew.getClass(), idClienteNew.getIdCli());
                animal.setIdCliente(idClienteNew);
            }
            Collection<Consulta> attachedConsultaCollectionNew = new ArrayList<Consulta>();
            for (Consulta consultaCollectionNewConsultaToAttach : consultaCollectionNew) {
                consultaCollectionNewConsultaToAttach = em.getReference(consultaCollectionNewConsultaToAttach.getClass(), consultaCollectionNewConsultaToAttach.getIdConsulta());
                attachedConsultaCollectionNew.add(consultaCollectionNewConsultaToAttach);
            }
            consultaCollectionNew = attachedConsultaCollectionNew;
            animal.setConsultaCollection(consultaCollectionNew);
            animal = em.merge(animal);
            if (idClienteOld != null && !idClienteOld.equals(idClienteNew)) {
                idClienteOld.getAnimalCollection().remove(animal);
                idClienteOld = em.merge(idClienteOld);
            }
            if (idClienteNew != null && !idClienteNew.equals(idClienteOld)) {
                idClienteNew.getAnimalCollection().add(animal);
                idClienteNew = em.merge(idClienteNew);
            }
            for (Consulta consultaCollectionOldConsulta : consultaCollectionOld) {
                if (!consultaCollectionNew.contains(consultaCollectionOldConsulta)) {
                    consultaCollectionOldConsulta.setIdAnimal(null);
                    consultaCollectionOldConsulta = em.merge(consultaCollectionOldConsulta);
                }
            }
            for (Consulta consultaCollectionNewConsulta : consultaCollectionNew) {
                if (!consultaCollectionOld.contains(consultaCollectionNewConsulta)) {
                    Animal oldIdAnimalOfConsultaCollectionNewConsulta = consultaCollectionNewConsulta.getIdAnimal();
                    consultaCollectionNewConsulta.setIdAnimal(animal);
                    consultaCollectionNewConsulta = em.merge(consultaCollectionNewConsulta);
                    if (oldIdAnimalOfConsultaCollectionNewConsulta != null && !oldIdAnimalOfConsultaCollectionNewConsulta.equals(animal)) {
                        oldIdAnimalOfConsultaCollectionNewConsulta.getConsultaCollection().remove(consultaCollectionNewConsulta);
                        oldIdAnimalOfConsultaCollectionNewConsulta = em.merge(oldIdAnimalOfConsultaCollectionNewConsulta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = animal.getIdAnimal();
                if (localizaAnimal(id) == null) {
                    throw new NonexistentEntityException("The animal with id " + id + " no longer exists.");
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
            Animal animal;
            try {
                animal = em.getReference(Animal.class, id);
                animal.getIdAnimal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The animal with id " + id + " no longer exists.", enfe);
            }
            Cliente idCliente = animal.getIdCliente();
            if (idCliente != null) {
                idCliente.getAnimalCollection().remove(animal);
                idCliente = em.merge(idCliente);
            }
            Collection<Consulta> consultaCollection = animal.getConsultaCollection();
            for (Consulta consultaCollectionConsulta : consultaCollection) {
                consultaCollectionConsulta.setIdAnimal(null);
                consultaCollectionConsulta = em.merge(consultaCollectionConsulta);
            }
            em.remove(animal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Animal> listarAnimal() {
        return findAnimalEntities(true, -1, -1);
    }

    public List<Animal> findAnimalEntities(int maxResults, int firstResult) {
        return findAnimalEntities(false, maxResults, firstResult);
    }

    private List<Animal> findAnimalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Animal.class));
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

    public Animal localizaAnimal(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Animal.class, id);
        } finally {
            em.close();
        }
    }

    public int contaAnimal() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Animal> rt = cq.from(Animal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

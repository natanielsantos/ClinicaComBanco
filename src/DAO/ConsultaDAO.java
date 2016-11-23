/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Animal;
import modelo.Consulta;

/**
 *
 * @author nataniel
 */
public class ConsultaDAO implements Serializable {

    public ConsultaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void cadastrar(Consulta consulta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Animal idAnimal = consulta.getIdAnimal();
            if (idAnimal != null) {
                idAnimal = em.getReference(idAnimal.getClass(), idAnimal.getIdAnimal());
                consulta.setIdAnimal(idAnimal);
            }
            em.persist(consulta);
            if (idAnimal != null) {
                idAnimal.getConsultaCollection().add(consulta);
                idAnimal = em.merge(idAnimal);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void alterar(Consulta consulta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consulta persistentConsulta = em.find(Consulta.class, consulta.getIdConsulta());
            Animal idAnimalOld = persistentConsulta.getIdAnimal();
            Animal idAnimalNew = consulta.getIdAnimal();
            if (idAnimalNew != null) {
                idAnimalNew = em.getReference(idAnimalNew.getClass(), idAnimalNew.getIdAnimal());
                consulta.setIdAnimal(idAnimalNew);
            }
            consulta = em.merge(consulta);
            if (idAnimalOld != null && !idAnimalOld.equals(idAnimalNew)) {
                idAnimalOld.getConsultaCollection().remove(consulta);
                idAnimalOld = em.merge(idAnimalOld);
            }
            if (idAnimalNew != null && !idAnimalNew.equals(idAnimalOld)) {
                idAnimalNew.getConsultaCollection().add(consulta);
                idAnimalNew = em.merge(idAnimalNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = consulta.getIdConsulta();
                if (localizaConsulta(id) == null) {
                    throw new NonexistentEntityException("The consulta with id " + id + " no longer exists.");
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
            Consulta consulta;
            try {
                consulta = em.getReference(Consulta.class, id);
                consulta.getIdConsulta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consulta with id " + id + " no longer exists.", enfe);
            }
            Animal idAnimal = consulta.getIdAnimal();
            if (idAnimal != null) {
                idAnimal.getConsultaCollection().remove(consulta);
                idAnimal = em.merge(idAnimal);
            }
            em.remove(consulta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consulta> listaConsulta() {
        return findConsultaEntities(true, -1, -1);
    }

    public List<Consulta> findConsultaEntities(int maxResults, int firstResult) {
        return findConsultaEntities(false, maxResults, firstResult);
    }

    private List<Consulta> findConsultaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consulta.class));
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

    public Consulta localizaConsulta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consulta.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsultaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consulta> rt = cq.from(Consulta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author adrianohrl
 * @param <E>
 * @param <K>
 */
public abstract class DAO<E, K> {
    
    protected EntityManager em;
    private final Class<E> clazz;
    
    protected DAO(EntityManager em, Class clazz) {
        this.em = em;
        this.clazz = (Class<E>) clazz;
    }

    public void create(E entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public void update(E entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public E find(K key) {
        return em.find(clazz, key);
    }

    public void remove(K key) {
        em.getTransaction().begin();
        E entity = find(key);
        em.remove(entity);
        em.getTransaction().commit();
    }

    public List<E> findAll() {
        return em.createQuery("FROM " + clazz.getSimpleName()).getResultList();
    }

    public long getCount() {
        return (long) em.createQuery("SELECT COUNT(*) FROM " + clazz.getSimpleName()).getSingleResult();
    }
    
    public abstract boolean isRegistered(E entity);
    
}

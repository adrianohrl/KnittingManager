/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck.dao;

import javax.persistence.EntityManager;
import kmm.dao.ComplexObject;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.DescriptableObjectDAO;
import kmm.paycheck.DayType;

/**
 *
 * @author adrianohrl
 */
public class DayTypeDAO extends DescriptableObjectDAO<DayType> implements ComplexObject<DayType>, ComplexObjectRelated<DayType> {

    public DayTypeDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(DayType type) {
        if (type == null) { 
            return;
        }
        em.getTransaction().begin();
        em.persist(type);
        ExtraDAO extraDAO = new ExtraDAO(em);
        extraDAO.creatingFullfilled(type.getExtra());
        em.merge(type);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(DayType type) {
        if (type == null) {
            return;
        }
        em.persist(type);
        ExtraDAO extraDAO = new ExtraDAO(em);
        extraDAO.creatingFullfilled(type.getExtra());
        em.merge(type);
    }
    
}

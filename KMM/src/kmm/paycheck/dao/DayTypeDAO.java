/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck.dao;

import javax.persistence.EntityManager;
import kmm.dao.ComplexObject;
import kmm.dao.DescriptableObjectDAO;
import kmm.paycheck.DayType;

/**
 *
 * @author adrianohrl
 */
public class DayTypeDAO extends DescriptableObjectDAO<DayType> implements ComplexObject<DayType> {

    public DayTypeDAO(EntityManager em) {
        super(em, DayType.class);
    }

    @Override
    public void createFullfilled(DayType type) {
        if (type == null) {
            return;
        }
        em.getTransaction().begin();
        this.persist(type);
        em.getTransaction().commit();
    }

    @Override
    public void persist(DayType type) {
        this.persist(type, type);
    }

    @Override
    public void persist(Object beingCreated, DayType type) {
        if (type == null) {
            return;
        }
        super.persist(beingCreated, type);
        //ExtraDAO extraDAO = new ExtraDAO(em);
        //extraDAO.creatingFullfilled(beingCreated, type.getExtra());
        em.merge(type);
    }

}

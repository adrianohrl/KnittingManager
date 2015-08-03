/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck.dao;

import javax.persistence.EntityManager;
import kmm.dao.ComplexObject;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.DAO;
import kmm.paycheck.ExtraTotal;

/**
 *
 * @author adrianohrl
 */
public class ExtraTotalDAO extends DAO<ExtraTotal, Long> implements ComplexObject<ExtraTotal>, ComplexObjectRelated<ExtraTotal> {

    public ExtraTotalDAO(EntityManager em) {
        super(em, ExtraTotal.class);
    }

    @Override
    public void createFullfilled(ExtraTotal extraTotal) {
        if (extraTotal == null) {
            return;
        }
        em.getTransaction().begin();
        this.persist(extraTotal);
        em.getTransaction().commit();
    }

    @Override
    public void persist(ExtraTotal extraTotal) {
        this.persist(extraTotal, extraTotal);
    }

    @Override
    public void creatingFullfilled(Object beingCreated, ExtraTotal extraTotal) {
        if (beingCreated.equals(extraTotal)) {
            em.merge(extraTotal);
            return;
        }
        this.persist(beingCreated, extraTotal);
    }

    @Override
    public void persist(Object beingCreated, ExtraTotal extraTotal) {
        if (extraTotal == null) {
            return;
        }
        if (!isRegistered(extraTotal)) {
            em.persist(extraTotal);
        }
        ExtraDAO extraDAO = new ExtraDAO(em);
        extraDAO.creatingFullfilled(beingCreated, extraTotal.getExtra());
        em.merge(extraTotal);
    }

    @Override
    public boolean isRegistered(ExtraTotal extraTotal) {
        return super.find(extraTotal.getCode()) != null;
    }

}

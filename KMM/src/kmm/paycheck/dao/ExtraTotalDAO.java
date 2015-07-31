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
        super(em);
    }

    @Override
    public void createFullfilled(ExtraTotal extraTotal) {
        if (extraTotal == null) { 
            return;
        }
        em.getTransaction().begin();
        em.persist(extraTotal);
        ExtraDAO extraDAO = new ExtraDAO(em);
        extraDAO.creatingFullfilled(extraTotal.getExtra());
        em.merge(extraTotal);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(ExtraTotal extraTotal) {
        if (extraTotal == null) {
            return;
        }
        em.persist(extraTotal);
        ExtraDAO extraDAO = new ExtraDAO(em);
        extraDAO.creatingFullfilled(extraTotal.getExtra());
        em.merge(extraTotal);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck.dao;

import javax.persistence.EntityManager;
import kmm.dao.ComplexObject;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.NameableObjectDAO;
import kmm.paycheck.Extra;

/**
 *
 * @author adrianohrl
 */
public class ExtraDAO extends NameableObjectDAO<Extra> implements ComplexObject<Extra>, ComplexObjectRelated<Extra> {

    public ExtraDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(Extra extra) {
        if (extra == null) { 
            return;
        }
        em.getTransaction().begin();
        em.persist(extra);
        DayTypeDAO typeDAO = new DayTypeDAO(em);
        typeDAO.creatingFullfilled(extra.getDayType());
        em.merge(extra);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(Extra extra) {
        if (extra == null) {
            return;
        }
        em.persist(extra);
        DayTypeDAO typeDAO = new DayTypeDAO(em);
        typeDAO.creatingFullfilled(extra.getDayType());
        em.merge(extra);
    }
    
}
